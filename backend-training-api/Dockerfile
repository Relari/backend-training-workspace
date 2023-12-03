FROM openjdk:11.0-jre-slim
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} backend-training.jar
ENTRYPOINT ["java","-jar","/backend-training.jar"]