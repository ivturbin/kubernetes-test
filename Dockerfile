FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY build/libs/kubernetes-test-0.0.1-SNAPSHOT-plain.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]