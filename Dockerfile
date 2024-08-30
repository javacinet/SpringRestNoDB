FROM openjdk:17-bullseye

# Copy the compiled jar to container
COPY target/SpringRestNoDB-0.0.1-SNAPSHOT.jar /app.jar

# Expose internal port to use
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app.jar"]