FROM tomee:8-jre-7.1.0-plume

RUN apt-get update
RUN apt-get install -y vim
RUN apt-get install -y tcpdump
RUN apt-get install -y net-tools
RUN apt-get install -y curl
RUN apt-get install -y nmap

COPY tomcat-users.xml /usr/local/tomee/conf
COPY tomee.xml /usr/local/tomee/conf
COPY system.properties /usr/local/tomee/conf
COPY logging.properties /usr/local/tomee/conf
COPY context.xml /usr/local/tomee/webapps/manager/META-INF
COPY mysql-connector-java-8.0.15.jar /usr/local/tomee/lib

RUN mkdir /usr/local/tomee/apps
COPY simpleEJB/ear/target/*.ear /usr/local/tomee/apps
