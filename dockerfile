FROM quyc07/java21:v1.0
VOLUME /tmp
ADD SecurityDemo-1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]