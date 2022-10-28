FROM adoptopenjdk/openjdk8

EXPOSE 8081
COPY target/*.jar customer-service.jar

ENTRYPOINT exec java $JAVA_OPTS -jar customer-service.jar