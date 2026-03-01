# Use Java 17
FROM eclipse-temurin:17-jdk-alpine

# Working directory
WORKDIR /app

# Copy all project files
COPY . .

# Give permission to Maven wrapper
RUN chmod +x mvnw

# Build Spring Boot jar
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run application
CMD ["sh","-c","java -jar target/*.jar"]
