FROM openjdk:8
EXPOSE 9500
ADD target/auth-server.jar spmia/auth-server.jar
ENTRYPOINT ["java", "-jar","spmia/auth-server.jar"]