package com.bkalli10.restful.web.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CourseData {

  private static final String dataFileName = "Courses.json";
  
  public List<Course> getCourseList() {
    List<Course> data = null;
    try {
      Gson gson = new Gson();
      Reader reader = new FileReader(dataFileName);
      Type listType = new TypeToken<ArrayList<Course>>() {}.getType();
      data = gson.fromJson(reader, listType);
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (data == null ) {
      data = new ArrayList<Course>();
    }
    return data;
  }

  public void saveCourseList(List<Course> data) {
    try {
      Gson gson = new Gson();
      FileWriter writer = new FileWriter(dataFileName);
      gson.toJson(data, writer);
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
