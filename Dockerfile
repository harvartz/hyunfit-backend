# Use a base image with Java 8
FROM openjdk:17-jdk-alpine

RUN apk --no-cache add tzdata
ENV TZ=Asia/Seoul

# Set the working directory
WORKDIR /app

# Copy the Spring Boot application WAR file to the container
COPY ./build/libs/hyunfit-0.0.1-SNAPSHOT.jar /app/hyunfit.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "hyunfit.jar"]