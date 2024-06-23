FROM tomcat:latest
RUN cp -R /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps
COPY ./target/registration-app-main.war /usr/local/tomcat/webapps/registration-app-main.war
