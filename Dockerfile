FROM gradle:8.0.2-jdk17-alpine
WORKDIR /home/gradle/project
ADD ./ ./
CMD ["gradle", "bootRun"] 