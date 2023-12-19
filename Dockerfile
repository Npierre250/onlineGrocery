FROM maven:3.8-openjdk-8 AS build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src

RUN mvn clean package  -Dskiptests

FROM openjdk:8-jre-slim-stretch

RUN mkdir /uploads

COPY --from=build /target/Online-Grocery-Store-Management-system-0.0.1-SNAPSHOT.jar Online-Grocery-Store-Management-system.jar

EXPOSE 9093

ENTRYPOINT [ "java","-jar","Online-Grocery-Store-Management-system.jar"]