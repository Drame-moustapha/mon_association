FROM eclipse-temurin:17-jre
WORKDIR /app
ARG JAR_FILE=target/backend-0.0.1-SNAPSHOT.jar
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
