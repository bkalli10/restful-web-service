package com.bkalli10.restful.web.service;

import java.util.List;
import org.apache.log4j.Logger;

public class CourseDao {

  final static Logger logger = Logger.getLogger(CourseDao.class);
  private CourseData courseData;

  public CourseDao() {
    this.courseData = new CourseData();
  }

  public CourseDao(CourseData data) {
    this.courseData = data;
  }

  public List<Course> getAllCourses() {
    return courseData.getCourseList();
  }

  public Course getCourse(int id) {

    logger.debug("getCourse: " + id);
    logger.info(String.format("course.data.file: %s", ConfigReader.getProperty("course.data.file")));

    List<Course> courses = courseData.getCourseList();

    for (Course course : courses) {
      if (course.getId() == id) {
        return course;
      }
    }
    return null;
  }

  public int createCourse(Course crs) {

    logger.debug("Creating course: " + crs);

    List<Course> courseList = courseData.getCourseList();
    boolean courseExists = false;
    if (courseList != null) {
      for (Course course : courseList) {
        if (course.getId() == crs.getId()) {
          courseExists = true;
          break;
        }
      }
    }
    if (!courseExists) {
      courseList.add(crs);
      courseData.saveCourseList(courseList);
      return 1;
    }
    return 0;
  }

  public int updateCourse(Course crs) {
    List<Course> courseList = courseData.getCourseList();

    for (Course course : courseList) {
      if (course.getId() == crs.getId()) {
        int index = courseList.indexOf(course);
        courseList.set(index, crs);
        courseData.saveCourseList(courseList);
        return 1;
      }
    }
    return 0;
  }

  public int deleteCourse(int id) {
    List<Course> courseList = courseData.getCourseList();

    for (Course course : courseList) {
      if (course.getId() == id) {
        int index = courseList.indexOf(course);
        courseList.remove(index);
        courseData.saveCourseList(courseList);
        return 1;
      }
    }
    return 0;
  }

}
