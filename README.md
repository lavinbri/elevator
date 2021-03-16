# elevator
Headless service with REST APIs to allow users to summon elevators

Service is based upon a Domain model with 3 entities:
+ User
+ Building
+ Elevator

![image](https://user-images.githubusercontent.com/8902011/111388671-9c027800-86a7-11eb-95ee-94e09c7a11f8.png)

## Running the service
Clone the repo and run the following commands
``` 
  mvn install
  mvn spring-boot:run 
```
  
## Calling APIs

The following APIs are available:

| Endpoint | Comment |
|---------|-------|
| GET /users | Get a list of users |
| POST /users | Create a new user |
| POST /users/{id}/changeName | Change the name of a user |
| POST /users/{id}/changeBuilding | Change the building a user is in |
| GET /buildings | Get a list of buildings |
| GET /buildings/{id}/elevators | Get a list of elevators and their status |
| POST /building/{id}/summonElevator | Summon an Elevator to a Floor |


A postman collection file with each request is available in the `postman` folder.



