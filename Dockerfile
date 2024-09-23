# Используем более новый образ Maven с JDK 21
FROM maven:3.9.4-eclipse-temurin-21 AS build
COPY pom.xml /app/
COPY Dockerfile /app/
COPY docker-compose.yaml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTests

# Используем официальный образ OpenJDK 21 для запуска приложения
FROM eclipse-temurin:21-jdk
COPY --from=build /app/target/movie-recommendation-bot-1.0-SNAPSHOT.jar /usr/app/movie-recommendation-bot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/app/movie-recommendation-bot.jar"]
