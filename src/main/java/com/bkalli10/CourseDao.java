package com.bkalli10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
  @SuppressWarnings("unchecked")
  public List<Course> getAllCourses() {

    List<Course> courseList = null;
    
    try {
      File file = new File("Courses.dat");
      if (file.exists()) {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        courseList = (List<Course>) ois.readObject();
        ois.close();
      } else {
        Course course = new Course(1, "Sample", "Please add a course");
        courseList = new ArrayList<Course>();
        courseList.add(course);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return courseList;
  }

  public Course getCourse(int id) {
    List<Course> courses = getAllCourses();

    for (Course course : courses) {
      if (course.getId() == id) {
        return course;
      }
    }
    return null;
  }

  public int addCourse(Course crs) {
    List<Course> courseList = getAllCourses();
    boolean courseExists = false;
    for (Course course : courseList) {
      if (course.getId() == crs.getId()) {
        courseExists = true;
        break;
      }
    }
    if (!courseExists) {
      courseList.add(crs);
      saveCourseList(courseList);
      return 1;
    }
    return 0;
  }

  public int updateCourse(Course crs) {
    List<Course> courseList = getAllCourses();

    for (Course course : courseList) {
      if (course.getId() == crs.getId()) {
        int index = courseList.indexOf(course);
        courseList.set(index, crs);
        saveCourseList(courseList);
        return 1;
      }
    }
    return 0;
  }

  public int deleteCourse(int id) {
    List<Course> courseList = getAllCourses();

    for (Course course : courseList) {
      if (course.getId() == id) {
        int index = courseList.indexOf(course);
        courseList.remove(index);
        saveCourseList(courseList);
        return 1;
      }
    }
    return 0;
  }

  private void saveCourseList(List<Course> courseList) {
    try {
      File file = new File("Courses.dat");
      FileOutputStream fos;

      fos = new FileOutputStream(file);

      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(courseList);
      oos.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
