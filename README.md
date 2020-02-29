# heroservice
This is the actual service which manages the CRUD operation of Heros. This is configured to invoke via Gateway and Eureka services part of standard spring architecture.
The service has following functionalities and uses in-memory **h2** database.
* Get List of Heros
* Create Hero
* Update Hero
* Delete Hero
* Search Hero

## Deployment
I have deployed and tested this in OpenShift, you can quickly spin a pod and try using an application type of Git and Java.

## Routes
I have not published any route as services are always invoked by Gateway and Eureka.
