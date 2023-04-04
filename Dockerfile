FROM gradle:6.9.2-jdk17-alpine
WORKDIR /home/gradle/project
COPY ./ ./