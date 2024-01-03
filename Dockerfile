# Stage 1: Build with Gradle
FROM openjdk:17.0.8-slim AS builder
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN ./gradlew clean build

# Stage 2: Run with JDK 17
FROM openjdk:17.0.8-slim
WORKDIR /app
COPY --from=builder /app/build/libs/SpringBootScaffold.jar .
EXPOSE 8080
CMD ["java", "-jar", "SpringBootScaffold.jar"]
