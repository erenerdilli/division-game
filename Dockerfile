FROM adoptopenjdk/openjdk11:alpine-jre

RUN mvn clean install

COPY target/divisiongame-service1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]