# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Install MySQL client
RUN apt-get update && apt-get install -y default-mysql-client

# Set working directory inside the container
WORKDIR /app

# Copy just the pom.xml first, to leverage Docker caching
COPY pom.xml /app/

# Copy the application's JAR file to the container
COPY target/ToDoApp-1.0-SNAPSHOT.jar /app/ToDoApp.jar

# Expose ports (application and health check)
EXPOSE 8080 8081

# Default command to run the application
CMD ["java", "-jar", "/app/ToDoApp.jar", "server", "config.yml"]
