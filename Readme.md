# RESTful-web-service

### Reference
https://www.tutorialspoint.com/restful/index.htm

### Downloading this Project

####### Download as .zip or clone

####### Change Directory
  cd restful-web-service

####### Build the *.war file
  mvn clean package

####### Copy the *.war file to webapps folder of tomcat
  cp target/*.war ~/bin/apache-tomcat-9.0.6/webapps/

####### Startup Tomcat
  apache-tomcat-9.0.6/bin/startup.sh
  apache-tomcat-9.0.6/bin/shutdown.sh (to shutdown at the end)

### Testing the Project
##### Call the following URLs via web browser or curl command
####### Print Hello World
  curl -X GET http://localhost:8080/restful-web-service/webapi/myresource

####### Get all courses
  curl -X GET http://localhost:8080/restful-web-service/webapi/course_service/courses  

####### Create a course
curl -X POST -d 'id=21&code=code21&name=name21' http://localhost:8080/restful-web-service/webapi/course_service/courses

####### Query the course that got created
curl -X GET http://localhost:8080/restful-web-service/webapi/course_service/courses/21

####### Update the course
curl -X PUT -d 'id=21&code=code21-B&name=name21-B' http://localhost:8080/restful-web-service/webapi/course_service/courses

####### Verify the update
curl -X GET http://localhost:8080/restful-web-service/webapi/course_service/courses/21

####### Delete the course
curl -X DELETE http://localhost:8080/restful-web-service/webapi/course_service/courses/21

####### Verify the delete
curl -X GET http://localhost:8080/restful-web-service/webapi/course_service/courses/21

### Process used in setting up this project
Reference: https://jersey.github.io/documentation/latest/getting-started.html

Download Apache Maven if it is not installed already. 

####### Create a project from the template

  mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false -DgroupId=com.example -DartifactId=restful-web-service -Dpackage=com.example -DarchetypeVersion=2.26

### Errors Faced
##### error 1
eclipse -> right click on project -> java build path -> add library -> system JRE -> choose version 8 

##### error 2
Eclipse error: The superclass “javax.servlet.http.HttpServlet” was not found on the Java Build Path [duplicate]
  Fix: Project → Properties → Target Runtimes → Apache Tomcat (any server)
  
  https://stackoverflow.com/questions/22756153/the-superclass-javax-servlet-http-httpservlet-was-not-found-on-the-java-build
  
##### error 3
java.lang.UnsupportedClassVersionError: javax/ws/rs/core/GenericType : Unsupported major.minor version 52.0
  Fix: Project → Properties → Target Runtimes → Apache Tomcat (any server)


