# Stage 1: Build with Gradle
FROM gradle:7.6.1-jdk17 AS builder
WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN gradle build --no-daemon

# Stage 2: Run with JDK 17
FROM openjdk:17.0.2-slim
WORKDIR /app
COPY --from=builder /app/build/libs/your-application-name.jar .
EXPOSE 8080
CMD ["java", "-jar", "your-application-name.jar"]
