package com.bkalli10;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "course")
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

  @XmlElement
  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  @XmlElement
  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  @XmlElement
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
}
