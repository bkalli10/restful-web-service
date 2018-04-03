package com.bkalli10.restful.web.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CourseValidation {

  final static Logger logger = Logger.getLogger(CourseValidation.class);

  public static List<Course> readCourse(String fileName) throws IOException {
    Gson gson = new Gson();
    Reader reader = new FileReader(fileName);
    Type listType = new TypeToken<ArrayList<Course>>() {}.getType();
    List<Course> data = gson.fromJson(reader, listType);
    reader.close();
    return data;
  }

  public static void writeCourse(String fileName, List<Course> data)
      throws IOException {
    Gson gson = new Gson();
    FileWriter writer = new FileWriter(fileName);
    gson.toJson(data, writer);
    writer.close();
  }

  public static boolean verifyCourses(List<Course> expectedList,
      List<Course> actualList, StringBuffer buf) {

    boolean flag = true;

    for (Course expected : expectedList) {
      flag = flag & verifyCourse(expected, actualList, buf);
    }

    return flag;
  }

  public static boolean verifyCourse(Course expected,
      List<Course> actualList, StringBuffer buf) {

    boolean flag = true;

    for (Course actual : actualList) {
      if (actual.getId() == expected.getId()) {

        flag = flag & validate(buf, actual.getCode(), expected.getCode(), "code", expected);
        flag = flag & validate(buf, actual.getName(), expected.getName(), "name", expected);

        return flag;
      }
    }

    buf.append("Record not found for key: ");
    buf.append(", id=").append(expected.getId());
    return false;
  }

  /**
   * @param buf
   * @param actual
   * @param expected
   * @param fldName
   * @param expectedCourse
   */
  private static boolean validate(StringBuffer buf, Integer actual, Integer expected, String fldName, Course expectedCourse) {
    if (!actual.equals(expected)) {
      buf.append(String.format("\n  Actual [%d] - expected [%d] did not match for field %s of record %s", actual,
          expected, fldName, expectedCourse.toString()));
      return false;
    }
    return true;
  }

  /**
   * @param buf
   * @param actual
   * @param expected
   * @param fldName
   * @param expectedCourse
   */
  private static boolean validate(StringBuffer buf, String actual, String expected, String fldName, Course expectedCourse) {
    if (!actual.equals(expected)) {
      buf.append(String.format("\n  Actual [%s] - expected [%s] did not match for field %s of record %s", actual,
          expected, fldName, expectedCourse.toString()));
      return false;
    }
    return true;
  }

}
