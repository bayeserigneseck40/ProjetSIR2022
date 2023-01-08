#Image de base
FROM openjdk:8-alpine
LABEL maintainer="sir@formation.com"
VOLUME /main-app
ADD target/formation-demo1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8084
# java -jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
