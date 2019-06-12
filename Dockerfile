FROM maven:3.6-jdk-8-alpine AS build
COPY . /simple-issue-tracker
WORKDIR /simple-issue-tracker

#RUN mvn clean install -U package spring-boot:repackage
RUN mvn package -Dmaven.test.skip=true  spring-boot:repackage

FROM openjdk:8u191-jre-alpine3.8
WORKDIR /simple-issue-tracker
COPY --from=build /simple-issue-tracker/target/simple-issue-tracker-1.0.0.jar /simple-issue-tracker
EXPOSE 8756
CMD ["java","-jar","simple-issue-tracker-1.0.0.jar"]