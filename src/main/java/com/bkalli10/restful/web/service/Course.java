package com.bkalli10.restful.web.service;

import java.io.Serializable;

public class Course implements Serializable {

  private static final long serialVersionUID = 1L;
  private int id;
  private String code; // e.g. CS206
  private String name; // e.g. Algorithms I

  public Course() {}

  public Course(int id, String code, String name) {
    this.id = id;
    this.code = code;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    } else if (!(object instanceof Course)) {
      return false;
    } else {
      Course course = (Course) object;
      if (id == course.getId() && name.equals(course.getName())
          && code.equals(course.getCode())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "Course [id=" + id + ", code=" + code + ", name=" + name + "]";
  }
}
