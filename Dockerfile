FROM hello-world

WORKDIR /jdbc_code

ADD jdbc_code/build/JDBCExample.class .
EXPOSE 8080
CMD "java" "JDBCExample"
