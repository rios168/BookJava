FROM openjdk:8-jdk-alpine
COPY management-0.0.1-SNAPSHOT.jar /tmp/app.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/tmp/app.jar"]
