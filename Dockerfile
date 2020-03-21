FROM maven AS builder
WORKDIR /src
COPY . .
RUN mvn package

FROM openjdk:8-jdk-alpine AS RUNNER
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=builder /src/target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]