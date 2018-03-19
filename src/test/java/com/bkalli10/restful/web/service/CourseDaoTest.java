package com.bkalli10.restful.web.service;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.google.gson.Gson;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseDaoTest {

  private Gson gson = new Gson();
  List<Course> initialCourses;
  private CourseData courseData;
  private CourseDao courseDao;

  /*
   * This method calls all other methods as there are dependencies between the test cases.
   * For example, we update the course in one test case and expect that test be visible to 
   */
  @Test
  public void testMain() throws IOException {
    init();
    testCreateCourse();
    testDeleteCourse();
    testGetCourse();
    testGetCourses();
    testUpdateCourse();
  }

  public void init() throws IOException {
    String fileName = "src/test/resources/initialCourses.json";
    this.initialCourses = CourseValidation.readCourse(fileName);
    this.courseData = new CourseDataMock(initialCourses);
    this.courseDao = new CourseDao(courseData);
  }

  public void testCreateCourse() {
    System.out.println("Executing testCreateCourse");
    int id = 31;
    String code = "code31";
    String name = "name31";
    Course course = new Course(id, code, name);
    int result = courseDao.createCourse(course);
    Assert.assertEquals(1, result);

    Course crs = courseDao.getCourse(id);
    Assert.assertEquals(course, crs);

    // trying to create the same course again will return 0
    int result2 = courseDao.createCourse(course);
    Assert.assertEquals(0, result2);
  }

  public void testDeleteCourse() {
    System.out.println("Executing testDeleteCourse");
    int id = 23;
    String code = "code23";
    String name = "name23";
    Course course = new Course(id, code, name);

    Course crs = courseDao.getCourse(id);
    Assert.assertEquals(course, crs);

    int result = courseDao.deleteCourse(id);
    Assert.assertEquals(1, result);

    Course crs2 = courseDao.getCourse(id);
    Assert.assertNull(crs2);
  }

  public void testGetCourse() {
    System.out.println("Executing testGetCourse");
    int id = 21;
    String code = "code21";
    String name = "name21";
    Course course = new Course(id, code, name);

    Course crs = courseDao.getCourse(id);
    Assert.assertEquals(course, crs);
  }

  public void testGetCourses() throws IOException {

    System.out.println("Executing testGetCourses");

    String fileName = "src/test/resources/getCoursesExpected.json";
    List<Course> expectedList = CourseValidation.readCourse(fileName);

    List<Course> actualList = courseDao.getAllCourses();

    // Printing the values so that we can compare them manually at jsondiff.com
    // if any asserts below fail.
    System.out.println("expectedList: " + gson.toJson(expectedList));
    System.out.println("actualList: " + gson.toJson(actualList));

    Assert.assertEquals(actualList.size(), 3);

    StringBuffer buf = new StringBuffer();

    boolean flag = CourseValidation.verifyCourses(expectedList, actualList, buf);
    Assert.assertFalse(buf.toString(), !flag);
  }

  public void testUpdateCourse() {
    System.out.println("Executing testUpdateCourse");
    int id = 22;
    String code = "code22";
    String name = "name22";
    Course course = new Course(id, code, name);
    Course courseAfterUpdate = new Course(id, code + "B", name + "B");

    Course crs = courseDao.getCourse(id);
    Assert.assertEquals(course, crs);

    int result = courseDao.updateCourse(courseAfterUpdate);
    Assert.assertEquals(1, result);

    Course crs2 = courseDao.getCourse(id);
    Assert.assertEquals(courseAfterUpdate, crs2);
  }

}
