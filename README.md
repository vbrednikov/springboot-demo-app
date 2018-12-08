[![Build Status](https://travis-ci.org/vbrednikov/springboot-demo-app.svg?branch=master)](https://travis-ci.org/vbrednikov/springboot-demo-app)

# SpringBoot helloworld web application

This repo contains a simple springboot web application that just displays a welcome string at 127.0.0.1:8080.

## Compile

`./gradlew build`

## Configure

Create a configuration file named as a produced jar, e.g., `gs-spring-boot-0.2.0.conf` for `gs-spring-boot-0.2.0.jar` with the contents like the following:

```
JAVA_OPTS="-Xmx128m -Xms128m"
RUN_ARGS="--server.port=8090"
```

Full list of variables is available at [Spring documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html#deployment-script-customization-when-it-runs).

## Run

```
java -jar gs-spring-boot-0.1.0.jar
```

Or

```
./gc-spring-boot-0.2.0.jar
```
