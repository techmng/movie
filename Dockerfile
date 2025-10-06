# Use a base image with Java installed
FROM openjdk:17-jdk-slim AS build

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory inside the container
WORKDIR /movie

# Copy the Maven/Gradle project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a smaller base image for the final application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /movie

# Copy the built JAR file from the build stage
COPY --from=build /movie/target/movie-0.0.1-SNAPSHOT.jar movie.jar

# Expose the port your Spring Boot application runs on
EXPOSE 8181

# Command to run the application
ENTRYPOINT ["java", "-jar", "movie.jar"]