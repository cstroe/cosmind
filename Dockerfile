FROM openjdk:10-jre

EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]

ADD /build/libs/cosidea-boot.jar /app.jar


