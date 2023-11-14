FROM openjdk:17-alpine AS runtime
WORKDIR /app

EXPOSE 8080

COPY ./target/Java_Projekt-0.0.1-SNAPSHOT*.jar ROOT.jar

ENTRYPOINT ["java","-jar","ROOT.jar"]