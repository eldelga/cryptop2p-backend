FROM gradle:8.0.2-jdk17-jammy
WORKDIR /home/gradle/project
COPY ./ ./
RUN sed -i -e 's/\r$//' gradlew
CMD ["gradlew", "bootRun"] 