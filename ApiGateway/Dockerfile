FROM openjdk:22-jdk
VOLUME /tmp
COPY target/ApiGateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/app.jar"]

