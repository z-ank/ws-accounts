FROM glassfish:latest

MAINTAINER z-ank

ADD build/libs/accounts-1.0.war /usr/local/glassfish4/glassfish/domains/domain1/autodeploy/

ADD start.sh /home
RUN chmod +x /home/start.sh
CMD /home/start.sh

EXPOSE 8080 4848