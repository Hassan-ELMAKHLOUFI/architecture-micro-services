FROM adoptopenjdk/openjdk8
EXPOSE 8761
COPY target/*.jar eureka-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar eureka-service.jar