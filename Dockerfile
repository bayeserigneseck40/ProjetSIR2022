FROM openjdk-11-alpine
LABEL maintainer="bayeserigne@gmail.com"
VOLUME /main-app
ADD target/formation-demo1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]
