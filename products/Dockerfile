FROM openjdk:22-jdk
VOLUME /tmp
COPY target/Products-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081

ENTRYPOINT ["java","-jar","/app.jar"]

