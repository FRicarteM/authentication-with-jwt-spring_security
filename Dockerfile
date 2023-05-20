FROM openjdk:20-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} authentication.jar
ENTRYPOINT ["java","-jar","/authentication.jar"]