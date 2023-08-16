FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /usr/src/app
COPY target/*.jar /usr/src/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app.jar"]