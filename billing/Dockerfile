FROM adoptopenjdk/openjdk8

EXPOSE 8085
COPY target/*.jar billing-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar billing-service.jar