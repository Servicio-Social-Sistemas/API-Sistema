# Build stage
FROM maven:3.9.3-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Final stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/formulario-geo-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "formulario-geo-0.0.1-SNAPSHOT.jar"]