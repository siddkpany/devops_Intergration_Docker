FROM openjdk:17
EXPOSE 8111
COPY target/encrypt-decrypt-rsa.jar /encrypt-decrypt-rsa.jar
CMD ["java", "-jar" ,"/encrypt-decrypt-rsa.jar"]