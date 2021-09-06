# Docker multi-stage build
# 1. Building the App with Maven
FROM maven:3-jdk-11
ADD . /work
WORKDIR /work
# Just echo so we can see, if everything is there :)
RUN ls -l
# Run Maven build
RUN mvn clean install
# Just using the build artifact and then removing the build-container
FROM openjdk:11-jdk
MAINTAINER Jose F Munoz
VOLUME /tmp
# Add Spring Boot app.jar to Container
COPY --from=0 "/work/target/*-SNAPSHOT.jar" app.jar
# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java -Dserver.port=$PORT -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]


## Docker file Gradle deployment
#FROM gradle:7.1.0-jdk8 as builder
#VOLUME /tmp
#RUN mkdir /work
#COPY . /work
#WORKDIR /work
#RUN gradle build
#FROM openjdk:8-jdk-alpine
#COPY --from=builder /work/build/libs/*SNAPSHOT.jar /work/app.jar
##CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/work/app.jar"]
#CMD ["java","-Dserver.port=$PORT", "-Djava.security.egd=file:/dev/./urandom","-jar","/work/app.jar"]
##CMD [ "java","-Dserver.port=$PORT", "-Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom","-jar","/work/app.jar"]
