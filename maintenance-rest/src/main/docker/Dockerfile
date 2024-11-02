#FROM adoptopenjdk:11-jre-hotspot
#FROM eclipse-temurin:21.0.2_13-jdk-jammy

FROM openjdk:21-slim
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar --spring.datasource.url=jdbc:postgresql://$POSTGRES:5432/db
EXPOSE 5432

#FROM java:8
#EXPOSE 8080
#ENV POSTGRES localhost
#ADD /target/manager.jar manager.jar
#ENTRYPOINT exec java $JAVA_OPTS -jar manager.jar --spring.datasource.url=jdbc:postgresql://$POSTGRES:5432/sample