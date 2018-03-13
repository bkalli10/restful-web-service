# RESTful-web-service

### Reference
https://www.tutorialspoint.com/restful/index.htm

### Downloading this project

##### Download as .zip or clone

##### Change Directory
  cd restful-web-service

##### Build the *.war file
  mvn clean package

##### Copy the *.war file to webapps folder of tomcat
  cp target/*.war ~/bin/apache-tomcat-9.0.6/webapps/

##### Call the following URLs via web browser or curl command
  curl -X GET http://localhost:8080/restful-web-service/webapi/myresource
  curl -X GET http://localhost:8080/restful-web-service/webapi/course_service/courses  

### Process used in setting up this project
Reference: https://jersey.github.io/documentation/latest/getting-started.html

##### Create a project from the template
  mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-webapp \
    -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false \
    -DgroupId=com.example -DartifactId=restful-web-service -Dpackage=com.example \
    -DarchetypeVersion=2.26
