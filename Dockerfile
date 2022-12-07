FROM openjdk:11.0.16-jdk
VOLUME /tmp
EXPOSE 8090
ADD ./target/spring-cloud-gateway-0.0.1-SNAPSHOT.jar spring-cloud-gateway.jar
ENTRYPOINT ["java","-jar","spring-cloud-gateway.jar"]