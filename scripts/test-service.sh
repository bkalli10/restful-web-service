#!/bin/bash

set -e
set -x

echo Print Hello World
curl --request GET http://localhost:8080/restful-web-service/webapi/myresource

echo Create three courses
curl --request POST --data 'id=41&code=code41&name=name41' http://localhost:8080/restful-web-service/webapi/course_service/courses
curl --request POST --data 'id=42&code=code42&name=name42' http://localhost:8080/restful-web-service/webapi/course_service/courses
curl --request POST --data 'id=43&code=code42&name=name43' http://localhost:8080/restful-web-service/webapi/course_service/courses

echo Get all courses
curl --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses

echo Get a course
curl --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses/41

echo Update a course
curl --request PUT --data 'id=41&code=code41-B&name=name41-B' http://localhost:8080/restful-web-service/webapi/course_service/courses

echo Verify the update
curl --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses/41

echo Delete a course
curl --request DELETE http://localhost:8080/restful-web-service/webapi/course_service/courses/41

echo Verify the delete
curl --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses/41


