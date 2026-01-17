# Usar imagen base de Maven para construir la aplicación
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .
COPY src ./src

# Construir la aplicación
RUN mvn clean package -DskipTests

# Usar imagen runtime de Java (versiones actuales disponibles)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copiar el jar desde la etapa de construcción
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Variable de entorno para el perfil de Spring (puede ser overridden)
ENV SPRING_PROFILES_ACTIVE=docker

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]