ENV SPRING_PROFILES_ACTIVE=docker

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/AuthMgmt.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
