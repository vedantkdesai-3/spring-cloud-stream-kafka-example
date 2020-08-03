FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar 
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8
ENTRYPOINT ["java","-jar","/app.jar"]