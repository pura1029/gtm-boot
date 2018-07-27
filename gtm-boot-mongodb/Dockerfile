FROM openjdk:8
ADD target/docker-spring-boot-mongodb.jar docker-spring-boot-mongodb.jar
EXPOSE 1045 1042
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://gautam:password@mongodb:27017/admin","-jar","docker-spring-boot-mongodb.jar"]