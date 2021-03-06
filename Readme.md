# RESTful-web-service

### Functional Features
1. Create a course
2. Update a course
3. Delete a course
4. Get details of a course
5. Get details of all courses

### Technical Features
1. Tomcat
2. Jersey
3. Unit tests using JUnit
4. Use mocked Data Access object to demonstrate the use of dependency injection
5. Validation class to validate list of Courses that could be out of order 
6. Logging using Log4J
7. Configuration using Properties
8. JSON serialize/deserialize
9. Use of Web Archive File (WAR)
10. Build using Maven
11. Source Version control using git
12. Use github as repository

### Downloading this Project

###### # Download as .zip or clone

###### # Change Directory
    cd restful-web-service

###### # Build the *.war file
    mvn clean package

###### # Copy the *.war file to webapps folder of tomcat
    cp target/*.war ~/bin/apache-tomcat-9.0.6/webapps/

### Testing the Project

###### # Startup Tomcat
    apache-tomcat-9.0.6/bin/startup.sh
    apache-tomcat-9.0.6/bin/shutdown.sh (to shutdown at the end)

##### Call the following URLs via web browser or curl command
###### # Print Hello World
    curl --request GET http://localhost:8080/restful-web-service/webapi/myresource

###### # Get OPTIONS
    curl --request OPTIONS http://localhost:8080/restful-web-service/webapi/course_service/courses  

###### # Create three courses
    curl --request POST --data 'id=41&code=code41&name=name41' http://localhost:8080/restful-web-service/webapi/course_service/courses
    curl --request POST --data 'id=42&code=code42&name=name42' http://localhost:8080/restful-web-service/webapi/course_service/courses
    curl --request POST --data 'id=43&code=code42&name=name43' http://localhost:8080/restful-web-service/webapi/course_service/courses

###### # Get all courses
    curl --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses  

###### # Get a course
    curl --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses/41

###### # Update a course
    curl --request PUT --data 'id=41&code=code41B&name=name41B' http://localhost:8080/restful-web-service/webapi/course_service/courses

###### # Verify the update
    curl --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses/41

###### # Delete a course
    curl --request DELETE http://localhost:8080/restful-web-service/webapi/course_service/courses/41

###### # Verify the delete
    curl --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses/41

### Process used in setting up this project
Download Apache Maven if it is not installed already. 

###### # Create a project from the template (see ref2)
    mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false -DgroupId=com.example -DartifactId=restful-web-service -Dpackage=com.example -DarchetypeVersion=2.26

###### # Create folders
    cd restful-web-service
    mkdir -p src/main/java/com/bkalli10/restful/web/service
    mkdir -p src/main/resources
    mkdir -p src/test/java/com/bkalli10/restful/web/service
    mkdir -p src/test/resources

###### # Create classes (see ref1)

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

### References
1. https://www.tutorialspoint.com/restful/index.htm
2. https://jersey.github.io/documentation/latest/getting-started.html

