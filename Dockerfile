FROM adoptopenjdk/openjdk11:alpine-jre

COPY target/divisiongame-service1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]