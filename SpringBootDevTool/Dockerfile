FROM openjdk:8-jdk-alpine

ADD ./target/spring-boot-dev-tool.war .

EXPOSE 3456

ENTRYPOINT ["java","-jar","spring-boot-dev-tool.war"]