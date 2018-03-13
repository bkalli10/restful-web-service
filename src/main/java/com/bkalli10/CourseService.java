package com.bkalli10;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/course_service")
public class CourseService {

  CourseDao courseDao = new CourseDao();
  private static final String SUCCESS_RESULT = "<result>success</result>";
  private static final String FAILURE_RESULT = "<result>failure</result>";

  @GET
  @Path("/courses")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Course> getCourses() {
    return courseDao.getAllCourses();
  }

  @GET
  @Path("/courses/{courseid}")
  @Produces(MediaType.APPLICATION_JSON)
  public Course getCourse(@PathParam("courseid") int courseid) {
    return courseDao.getCourse(courseid);
  }

  @POST
  @Path("/courses")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String createCourse(
      @FormParam("id") int id,
      @FormParam("code") String code,
      @FormParam("name") String name,
      @Context HttpServletResponse servletResponse)
      throws IOException {
    
    Course course = new Course(id, code, name);
    int result = courseDao.addCourse(course);
    if (result == 1) {
      return SUCCESS_RESULT;
    }
    return FAILURE_RESULT;
  }

  @PUT
  @Path("/courses")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String updateCourse(
      @FormParam("id") int id, 
      @FormParam("code") String code,
      @FormParam("name") String name, 
      @Context HttpServletResponse servletResponse)
      throws IOException {

    Course course = new Course(id, code, name);
    int result = courseDao.updateCourse(course);
    if (result == 1) {
      return SUCCESS_RESULT;
    }
    return FAILURE_RESULT;
  }

  @DELETE
  @Path("/courses/{courseid}")
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteCourse(@PathParam("courseid") int courseid) {
    int result = courseDao.deleteCourse(courseid);
    if (result == 1) {
      return SUCCESS_RESULT;
    }
    return FAILURE_RESULT;
  }

  @OPTIONS
  @Path("/courses")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSupportedOperations() {
    return "<operations>GET, PUT, POST, DELETE</operations>";
  }
}

