FROM openjdk:8-jdk-alpine

WORKDIR /app

ARG JAR_FILE=target/employee-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
