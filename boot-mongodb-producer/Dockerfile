FROM openjdk:8
ADD target/boot-mongodb-producer.jar boot-mongodb-producer.jar
EXPOSE 1035 30082
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://gautam:password@mongo-service:27017/admin","-jar","boot-mongodb-producer.jar"]