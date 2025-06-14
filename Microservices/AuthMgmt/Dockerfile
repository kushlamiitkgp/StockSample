FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/authMgmt.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
