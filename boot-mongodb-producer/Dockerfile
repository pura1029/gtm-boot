FROM openjdk:8
ADD target/boot-mongodb-producer.jar boot-mongodb-producer.jar
EXPOSE 1045 1042
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://gautam:password@mongo-service:27017/admin","-jar","boot-mongodb-producer.jar"]