package com.bkalli10.restful.web.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import org.apache.log4j.Logger;

@Path("/course_service")
public class CourseService {

  final static Logger logger = Logger.getLogger(CourseService.class);
  private CourseDao courseDao = new CourseDao();

  @GET
  @Path("/courses")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Course> getCourses(@Context HttpServletRequest request) {
    String url = request.getRequestURL().toString();
    // String query = request.getQueryString();
    logger.debug(url);
    return courseDao.getAllCourses();
  }

  @GET
  @Path("/courses/{courseid}")
  @Produces(MediaType.APPLICATION_JSON)
  public Course getCourse(@PathParam("courseid") int courseid,
      @Context HttpServletRequest request) {
    String url = request.getRequestURL().toString();
    // String query = request.getQueryString();
    logger.debug(url);
    return courseDao.getCourse(courseid);
  }

  @POST
  @Path("/courses")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String createCourse(@FormParam("id") int id, @FormParam("code") String code,
      @FormParam("name") String name, @Context HttpServletResponse servletResponse,
      @Context HttpServletRequest request) throws IOException {

    String url = request.getRequestURL().toString();
    // String query = request.getQueryString();
    logger.debug(url);

    Course course = new Course(id, code, name);
    int result = courseDao.createCourse(course);
    if (result == 1) {
      return Constants.SUCCESS_RESULT;
    }
    return Constants.FAILURE_RESULT;
  }

  @PUT
  @Path("/courses")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String updateCourse(@FormParam("id") int id, @FormParam("code") String code,
      @FormParam("name") String name, @Context HttpServletResponse servletResponse,
      @Context HttpServletRequest request) throws IOException {

    String url = request.getRequestURL().toString();
    // String query = request.getQueryString();
    logger.debug(url);

    Course course = new Course(id, code, name);
    int result = courseDao.updateCourse(course);
    if (result == 1) {
      return Constants.SUCCESS_RESULT;
    }
    return Constants.FAILURE_RESULT;
  }

  @DELETE
  @Path("/courses/{courseid}")
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteCourse(@PathParam("courseid") int courseid,
      @Context HttpServletRequest request) {

    String url = request.getRequestURL().toString();
    // String query = request.getQueryString();
    logger.debug(url);

    int result = courseDao.deleteCourse(courseid);
    if (result == 1) {
      return Constants.SUCCESS_RESULT;
    }
    return Constants.FAILURE_RESULT;
  }

  @OPTIONS
  @Path("/courses")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSupportedOperations(@Context HttpServletRequest request) {

    String url = request.getRequestURL().toString();
    // String query = request.getQueryString();
    logger.debug(url);

    return Constants.OPERATIONS;
  }
}

