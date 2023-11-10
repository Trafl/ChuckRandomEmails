# ChuckRandomEmails
This microservice was conceived as a practical exercise to apply recently acquired concepts. 
The implementation adopts a decoupled architecture, typical of microservices, encompassing both synchronous and asynchronous calls. 
Additionally, the service incorporates the ability to consume external APIs from the Web, following discovery and gateway standards.
It's worth noting that the email service functions for both Amazon Simple Email Service and the Google SMTP server, utilizing two distinct sets of application properties for this implementation.

The main functionality of this microservice is to send messages containing random phrases from the famous actor Chuck Norris to the email addresses of registered users.

## Technologies Used
- Java 17
- Spring Boot
- Spring Data MongoDB
- Lombok
- MongoDB
- SpringDoc
- Spring Gateway
- Spring Netflix Eureka
- Spring Cloud OpenFeign
- RabbitMQ
- Docker
- Amazon Simple Email Service
- Google SMTP server
- External API [https://api.chucknorris.io/](https://api.chucknorris.io/)

## Documentation
Each microservice has its own documentation in the Swagger standard for a better understanding of each End-point.
Access "http://localhost:8081/" and open the Eureka graphical interface to find out which port each application is running on.
After that, replace the connected port in http://localhost:"youPort" and add "/swagger-ui/index.html#/".

## Requirements 
To run this project, you must have Docker installed on your machine because RabbitMQ has been simulated by container

## How to run this project
Open Docker and in the terminal type
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management
```
To stop execution, use the command:
`
Ctrl + C
`

First read the documentation for a better understanding of End-Points.
After the containers are created, use a program like `Postman` or `Insomnia` to make http requests.
Once you have Insomnia or Postman open, go to the url [localhost:8082/chuck-user/send-me-a-email](localhost:8082/chuck-user/send-me-a-email) to interact with the rest api.

## Email example
![example](https://github.com/Trafl/assets/blob/main/chuclk.png)
