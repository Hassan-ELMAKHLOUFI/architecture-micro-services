FROM adoptopenjdk/openjdk8
EXPOSE 8888
COPY target/*.jar gateway-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar gateway-service.jar