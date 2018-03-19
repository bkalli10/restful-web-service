package com.bkalli10.restful.web.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CourseData2 {

  private static final String dataFileName = "Courses.dat";

  public List<Course> getCourseList() {
    
    List<Course> courseList = null;

    try {
      File file = new File(dataFileName);
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

  public void saveCourseList(List<Course> courseList) {
    try {
      File file = new File(dataFileName);
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
