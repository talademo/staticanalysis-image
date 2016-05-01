FROM ubuntu:14.04

RUN apt-get update
RUN apt-get install -y openjdk-7-jre

WORKDIR /home

LABEL x="c"

ADD jdbc_code/build/JDBCExample.class JDBCExample.class
ADD mysql-connector-java-5.1.38-bin.jar mysql-connector-java-5.1.38-bin.jar 
EXPOSE 8080
CMD "java" "-cp" ".:mysql-connector-java-5.1.38-bin.jar" "JDBCExample"
