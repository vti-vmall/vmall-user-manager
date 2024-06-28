FROM eclipse-temurin:17.0.11_9-jre
MAINTAINER tunk-vti
COPY ./target/*.jar app.jar
COPY ./opentelemetry-javaagent-1.28.0.jar opentelemetry-javaagent-1.28.0.jar
ENTRYPOINT ["java","-jar","/app.jar"]