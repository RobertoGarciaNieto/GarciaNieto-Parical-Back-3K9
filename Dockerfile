# Etapa de construcción
FROM alpine:latest as build

# Establecer el directorio de trabajo
WORKDIR /app

# Actualizar el sistema y agregar OpenJDK 17
RUN apk update && apk add openjdk17

# Copiar los archivos necesarios para la construcción
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle gradle
COPY src src

# Dar permisos de ejecución al script gradlew
RUN chmod +x ./gradlew

# Construir la aplicación
RUN ./gradlew bootJar --no-daemon

# Etapa de ejecución
FROM openjdk:17-alpine

# Establecer el directorio de trabajo
WORKDIR /app

# Exponer el puerto en el que la aplicación escucha
EXPOSE 8080

# Copiar el archivo JAR construido desde la etapa de construcción
COPY --from=build /app/build/libs/*.jar ./app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]