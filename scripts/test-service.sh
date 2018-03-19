echo!/bin/bash

set -e
set -x

echo Print Hello World
curl -X GET http://localhost:8080/restful-web-service/webapi/myresource

echo Get all courses
curl -X GET http://localhost:8080/restful-web-service/webapi/course_service/courses

echo Create a course
curl -X POST -d 'id=21&code=code21&name=name21' http://localhost:8080/restful-web-service/webapi/course_service/courses

echo Query the course that just got created
curl -X GET http://localhost:8080/restful-web-service/webapi/course_service/courses/21

echo Update the course
curl -X PUT -d 'id=21&code=code21-B&name=name21-B' http://localhost:8080/restful-web-service/webapi/course_service/courses

echo Verify the update
curl -X GET http://localhost:8080/restful-web-service/webapi/course_service/courses/21

echo Delete the course
curl -X DELETE http://localhost:8080/restful-web-service/webapi/course_service/courses/21

echo Verify the delete
curl -X GET http://localhost:8080/restful-web-service/webapi/course_service/courses/21


