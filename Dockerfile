# Generar el jar
# FROM maven:3.8.5-openjdk-17
# WORKDIR /build
# COPY . .
# Ejecutar el jar
FROM openjdk:17-alpine
WORKDIR /app
COPY bootcamp-0.0.1-SNAPSHOT.jar ./
EXPOSE 8080
CMD [ "java", "-jar", "bootcamp-0.0.1-SNAPSHOT.jar" ]

