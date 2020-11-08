FROM tomcat:9.0-jre8-alpine

MAINTAINER gourav kumar <gov.kumarbharatdwaj@gmail.com>

ARG WAR_FILE = target/spring-boot-dev-tool.war

EXPOSE 3456

WORKDIR /usr/local/tomcat/webapps/

COPY ${WAR_FILE} spring-boot-dev-tool.war