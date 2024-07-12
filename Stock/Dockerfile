FROM openjdk:22-jdk
VOLUME /tmp
COPY target/Stock-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app.jar"]

