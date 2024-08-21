FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY build/libs/kubernetes-test.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]