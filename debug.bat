@echo off
echo Starting debug container with Maven and your Java code...

@REM in localhost run postgres container
docker run -d ^
  --name postgres_db ^
  -e POSTGRES_DB=eLearning ^
  -e POSTGRES_USER=postgres ^
  -e POSTGRES_PASSWORD=nesrine ^
  -v postgres_data:/var/lib/postgresql/data ^
  -p 5432:5432 ^
  --network app-network ^
  --ip 172.20.0.2 ^
  postgres:15


cd E:\neeeeesss\eLearning_project_backend\application

docker run -it --rm ^
  --name sb3jwt-debug ^
  --network app-network ^
  -v "%cd%":/app ^
  -w /app ^
  -p 8080:8080 ^
  maven:3.8.6-eclipse-temurin-17 ^
  bash

@REM inside docker container: mvn clean package  then   java -jar target/*.jar


@REM you can test your SB app with postman
echo Debug session ended.
pause