# Usar una imagen base con JDK 11 y Maven
FROM amazoncorretto:21-alpine-jdk
COPY target/crud-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]