FROM gradle:6.9.2-jdk17-alpine
WORKDIR /home/gradle/project
COPY ./ ./
RUN gradle wrapper --gradle-version 6.9
# RUN chmod +x ./gradlew
# RUN sed -i -e 's/\r$//' ./gradlew
CMD ["gradlew", "bootRun"] 