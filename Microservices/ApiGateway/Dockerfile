# Build stage
FROM eclipse-temurin:17-jdk as builder

WORKDIR /app
COPY build/libs/ApiGateway.jar ApiGateway.jar

# Final stage (runtime only, no shell, no package manager, ultra secure)
FROM gcr.io/distroless/java17

COPY --from=builder /app/ApiGateway.jar ApiGateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ApiGateway.jar"]
