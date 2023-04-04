FROM gradle:8.0.2-jdk17-jammy
WORKDIR /home/gradle/project
COPY ./ ./
RUN chmod +x gradlew
CMD ["gradlew", "bootRun"] 