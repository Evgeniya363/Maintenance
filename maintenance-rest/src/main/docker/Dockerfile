
FROM openjdk:21-slim
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar --spring.datasource.url=jdbc:postgresql://$POSTGRES:5432/db
EXPOSE 5432
