# Базовый образ JRE slim для запуска приложения
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Устанавливаем postgresql-client для использования pg_isready
RUN apt-get update && apt-get install -y postgresql-client

# Копируем заранее собранный JAR файл
COPY build/libs/course-service-0.0.1-SNAPSHOT.jar course-service.jar

# Указываем порт для приложения
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "/app/course-service.jar"]
