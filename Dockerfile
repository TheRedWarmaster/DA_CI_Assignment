FROM openjdk:latest
ADD target/lib /usr/share/ReviewApi/lib
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/ReviewApi/ReviewApi.jar