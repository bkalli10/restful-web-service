package com.bkalli10;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class WebServiceTester  {

   private Client client;
   private String REST_SERVICE_URL = "http://localhost:8080/restful-web-service/webapi/course_service/courses";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public static void main(String[] args){
      WebServiceTester tester = new WebServiceTester();
      //initialize the tester
      tester.init();

      //test get all courses Web Service Method
      tester.testGetAllCourses();

      //test add course Web Service Method
      tester.testAddCourse();

      //test get course Web Service Method
      tester.testGetCourse();

      //test add course Web Service Method
      tester.testAddCourse12();

      //test update course Web Service Method
      tester.testUpdateCourse();

      //test delete course Web Service Method
      //tester.testDeleteCourse();
   }

   //Test: Get list of all courses
   //Test: Check if list is not empty
   private void testGetAllCourses(){
      GenericType<List<Course>> list = new GenericType<List<Course>>() {};
      List<Course> courses = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_JSON)
         .get(list);
      String result = PASS;
      if(courses.isEmpty()){
         result = FAIL;
      }
      System.out.println("Test case name: testGetAllCourses, Result: " + result );
   }

   //Test: Add Course of id 11
   //Test: Check if result is success XML.
   private void testAddCourse(){
      Form form = new Form();
      form.param("id", "11");
      form.param("code", "CS-126");
      form.param("name", "Java I");

      String callResult = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_JSON)
         .post(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);

      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testAddCourse, Result: " + result );
   }

   //Test: Get Course of id 11
   //Test: Check if course is same as sample course
   private void testGetCourse(){
      Course sampleCourse = new Course();
      sampleCourse.setId(11);

      Course course = client
         .target(REST_SERVICE_URL)
         .path("/{courseid}")
         .resolveTemplate("courseid", 11)
         .request(MediaType.APPLICATION_JSON)
         .get(Course.class);
      String result = FAIL;
      if(sampleCourse != null && sampleCourse.getId() == course.getId()){
         result = PASS;
      }
      System.out.println("Test case name: testGetCourse, Result: " + result );
   }

   //Test: Add Course of id 12
   //Test: Check if result is success XML.
   private void testAddCourse12(){
      Form form = new Form();
      form.param("id", "12");
      form.param("code", "CS-206");
      form.param("name", "Algorithms I");

      String callResult = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_JSON)
         .post(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);

      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testAddCourse12, Result: " + result );
   }

   //Test: Update Course of id 12
   //Test: Check if result is success XML.
   private void testUpdateCourse(){
      Form form = new Form();
      form.param("id", "12");
      form.param("code", "CS-301");
      form.param("name", "Software Engineering");

      String callResult = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_JSON)
         .put(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testUpdateCourse, Result: " + result );
   }

   //Test: Delete Course of id 12
   //Test: Check if result is success XML.
   private void testDeleteCourse(){
      String callResult = client
         .target(REST_SERVICE_URL)
         .path("/{courseid}")
         .resolveTemplate("courseid", 12)
         .request(MediaType.APPLICATION_JSON)
         .delete(String.class);

      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testDeleteCourse, Result: " + result );
   }
}
