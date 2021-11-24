FROM maven:3-jdk-8-alpine

WORKDIR /usr/src/app

# COPY . /usr/src/app
COPY target/springboot-sample-0.0.1-SNAPSHOT.jar app.jar
RUN mvn package

ENV PORT 5000
EXPOSE $PORT
CMD [ "sh", "-c", "mvn -Dserver.port=${PORT} spring-boot:run" ]
