FROM openjdk:8u171-jre-slim

COPY target/template-maven-app*.jar /usr/lib/templateApp/app.jar
WORKDIR /usr/lib/templateApp
VOLUME /etc/cfg
EXPOSE 80 8081

ENV SPRING_PROFILES_ACTIVE=dev
ENV JAVA_OPTS="-Xms30m -Xmx30m -Xss256k -XX:MaxMetaspaceSize=64m"
ENV CONFIG_PATH=/etc/cfg/

ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
