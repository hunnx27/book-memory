FROM maven:3-jdk-8-alpine

RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime && echo Asia/Seoul > /etc/timezone

COPY target/springboot-sample-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-D64","-Xms4G","-Xmx4G","-XX:MaxMetaspaceSize=1024m","-XX:NewSize=1024m","-XX:MaxNewSize=1024m","-XX:-UseAdaptiveSizePolicy","-Djava.net.preferIPv4Stack=true","-Djava.security.egd=file:/dev/urandom","-jar","/app.jar"]



# WORKDIR /usr/src/app
# COPY . /usr/src/app

# RUN mvn package

# ENV PORT 5000
# EXPOSE $PORT
# CMD [ "sh", "-c", "mvn -Dserver.port=${PORT} spring-boot:run" ]


