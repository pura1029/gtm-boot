# gtm-boot
Spring boot application with mongodb
i have created two micro services, one(student-producer) is produce the student data in mongodb and other one(student-consumer) is consume the data from mongo db.
it is compatiable to run on docker container and also can deploy on kubernetes cluster.

docker compose file : gtm-boot\docker\prod-cons
step 1: create image file and push into docker hub 
step 2: go k8s app yml file : gtm-boot\k8s
step 3: create the mongodb instance deployment
step 4: go k8s app yml file : gtm-boot\k8s\prod-cons
step 5: create the micro service deployment

access :
producer url : https://{hostName}:{port}/swagger-ui.html#/
consumer url : https://{hostName}:{port}/swagger-ui.html#/
