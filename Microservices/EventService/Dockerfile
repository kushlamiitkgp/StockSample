# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file (replace with your actual jar name)
COPY build/libs/eventService.jar app.jar

# Expose port
EXPOSE 9001

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
