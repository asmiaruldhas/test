# Build Stage
FROM maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /app
COPY spring-boot-demo/demo/ .
RUN mvn clean package -DskipTests

# Run Stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
