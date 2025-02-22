# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory in the container
WORKDIR /app

# Copy the JAR file from target directory to container
COPY target/*.jar app.jar

# Expose the application port (change if needed)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
