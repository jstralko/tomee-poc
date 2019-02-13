FROM tomee:8-jre-1.7.5-plume

RUN apt-get update
RUN apt-get install -y vim
RUN apt-get install -y tcpdump

COPY tomcat-users.xml /usr/local/tomee/conf
COPY tomee.xml /usr/local/tomee/conf

RUN mkdir /usr/local/tomee/apps
COPY clientEJB/ear/target/*.ear /usr/local/tomee/apps
