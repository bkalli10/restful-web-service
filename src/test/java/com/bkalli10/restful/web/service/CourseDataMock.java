package com.bkalli10.restful.web.service;

import java.util.List;

public class CourseDataMock extends CourseData {

  private List<Course> courseList = null;
  
  public CourseDataMock(List<Course> courseList) {
    this.courseList = courseList;
  }

  @Override
  public List<Course> getCourseList() {
    return courseList;
  }

  @Override
  public void saveCourseList(List<Course> courseList) {
    this.courseList = courseList;
  }

}
