FROM openjdk:8
ADD target/boot-mongodb-consumer.jar boot-mongodb-consumer.jar
EXPOSE 1036 30084
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://gautam:password@mongo-service:27017/admin","-jar","boot-mongodb-consumer.jar"]