# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Copy the entire project
COPY . .
# Move into the folder where pom.xml actually is
WORKDIR /app/firstApp
# Run the build
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
# Copy the jar file from the build stage
COPY --from=build /app/firstApp/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
