FROM openjdk:8
ADD target/sprintly-api-activities.jar sprintly-api-activities.jar
EXPOSE 8090
#CMD ./mvnw.cmd clean package spring-boot:repackage
#CMD java -jar -Dserver.port=8090  target/sprintly-api-skills.jar
ENTRYPOINT ["java", "-Dserver.port=8090", "-jar", "sprintly-api-activities.jar"]