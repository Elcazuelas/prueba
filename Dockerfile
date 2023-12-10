FROM openjdk:21

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR construido de tu proyecto en el contenedor
COPY target/ProyectoCENS-1.0.jar app.jar

# Expone el puerto en el que tu aplicación Spring Boot está ejecutando
EXPOSE 8080

# Comando para ejecutar tu aplicación cuando el contenedor se inicia
CMD ["java", "-jar", "app.jar"]