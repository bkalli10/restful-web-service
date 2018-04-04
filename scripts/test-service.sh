#!/bin/bash

set -e
set -x

echo Print Hello World
curl --write-out "%{http_code}\n" --request GET http://localhost:8080/restful-web-service/webapi/myresource

echo Create three courses
curl --write-out "\n%{http_code}\n" --request POST --data 'id=41&code=code41&name=name41' http://localhost:8080/restful-web-service/webapi/course_service/courses
curl --write-out "\n%{http_code}\n" --request POST --data 'id=42&code=code42&name=name42' http://localhost:8080/restful-web-service/webapi/course_service/courses
curl --write-out "\n%{http_code}\n" --request POST --data 'id=43&code=code42&name=name43' http://localhost:8080/restful-web-service/webapi/course_service/courses

echo Get all courses
curl --write-out "\n%{http_code}\n" --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses

echo Get a course
curl --write-out "\n%{http_code}\n" --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses/41

echo Update a course
curl --write-out "\n%{http_code}\n" --request PUT --data 'id=41&code=code41-B&name=name41-B' http://localhost:8080/restful-web-service/webapi/course_service/courses

echo Verify the update
curl --write-out "\n%{http_code}\n" --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses/41

echo Delete a course
curl --write-out "\n%{http_code}\n" --request DELETE http://localhost:8080/restful-web-service/webapi/course_service/courses/41

echo Verify the delete
curl --write-out "%{http_code}\n" --request GET http://localhost:8080/restful-web-service/webapi/course_service/courses/41

