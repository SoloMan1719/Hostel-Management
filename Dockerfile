# Use Java 17
FROM eclipse-temurin:17-jdk-alpine

# App folder
WORKDIR /app

# Copy project files
COPY . .

# Build jar
RUN ./mvnw clean package -DskipTests

# Run application
CMD ["java","-jar","target/platinum_HostelManagement-0.0.1-SNAPSHOT.jar"]
