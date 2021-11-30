# template spring boot maven app with docker
It is based on spring boot microservice with docker fabric8 pluging.

## Requirements
* java 8
* Maven 3
* spring boot
* docker

## COMPILING JAR & RUN UNIT-TEST

```
mvn clean package
```

## building a docker container

```
mvn clean package fabric8:build
```

## USAGE

### Run jar

```
java -jar target/template-maven-app-1.0.0.jar
```

### Run docker

```
docker run -it -p 8081:8081 -p 8082:8082 mauro/template-maven-app:1.0.0
```

## API

* GET http://localhost:8081/ping
Start the monitoring services
```
Response example
{
    "value": "pong"
}
```

* GET http://localhost:8082/actuator
get actuators.

mvn clean package javadoc:javadoc depgraph:graph -DshowGroupIds -DshowConflicts
sed -i 's/</\\</g; s/>/\\>/g; s/-\\>/->/g' target/maven-template.urm.dot
dot -Tpng target/maven-template.urm.dot -o target/maven-template.urm.png
dot -Tpng target/dependency-graph.dot -o target/dependency-graph.png
