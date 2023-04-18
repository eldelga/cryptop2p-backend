# Establecer la imagen base de Java
FROM gradle:7.3.0-jdk17-alpine

# Establecer el directorio de trabajo en la imagen
WORKDIR /home/gradle/project

# Copiar el archivo build.gradle y settings.gradle a la imagen
COPY build.gradle .
COPY settings.gradle .

# Copiar la carpeta src a la imagen
COPY src/ src/

# Ejecutar el comando gradle wrapper para descargar el Gradle Wrapper
RUN gradle wrapper --gradle-version 7.3

# Copiar todos los archivos del proyecto a la imagen
COPY . .

RUN chmod +x gradlew

# Ejecutar el comando de construcción del proyecto con Gradle
RUN ./gradlew build

# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "build/libs/backend-cryptop2p-0.0.1-SNAPSHOT.jar"]