# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY devops-app-1.0.0.jar /app/devops-app-1.0.0.jar

# Make port 8080 available to the world outside this container
EXPOSE 3000

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","devops-app-1.0.0.jar"]
