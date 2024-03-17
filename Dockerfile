FROM openjdk:8
EXPOSE 8090
ADD target/MedicareApp-AdminService-0.0.1-SNAPSHOT.war MedicareApp-AdminService-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/MedicareApp-AdminService-0.0.1-SNAPSHOT.war" ]