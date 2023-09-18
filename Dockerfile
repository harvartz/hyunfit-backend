# Use a base image with Java 8
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Spring Boot application WAR file to the container
COPY ./build/libs/hyunfit-0.0.1-SNAPSHOT.jar /app/hyunfit.jar

# Expose port 48080 for the Spring Boot application
EXPOSE 48080

# Run the Spring Boot application
CMD ["java", "-jar", "hyunfit.jar"]