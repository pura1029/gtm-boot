# gtm-boot
<b> Spring boot application with mongodb</b> :  </br>
i have created two micro services, one(student-producer) is produce the student data in mongodb and other one(student-consumer) is consume the data from mongo db.   </br>
it is compatiable to run on docker container and also can deploy on kubernetes cluster.  </br>

docker compose file : gtm-boot\docker\prod-cons  </br>
step 1: create image file and push into docker hub   </br>
step 2: go k8s app yml file : gtm-boot\k8s  </br>
step 3: create the mongodb instance deployment    </br>
step 4: go k8s app yml file : gtm-boot\k8s\prod-cons   </br>
step 5: create the micro service deployment   </br>

<b> How to access : </b>
producer url : https://{hostName}:{port}/swagger-ui.html#/   </br>
consumer url : https://{hostName}:{port}/swagger-ui.html#/
