# Microservice Users

A standalone User domain service built with Spring Boot and PostgreSQL â€“ part of the Microstack distributed architecture.

í³Œ Overview

The Users Microservice is responsible for managing all user-related operations within the Microstack platform.
This service runs independently, exposes RESTful APIs, and communicates with other microservices in a distributed architecture.

It follows modern backend engineering practices:

Isolated domain (User management)

Independent build, deploy, and scaling

Clean architecture with controllers, services, and repositories

Integration with PostgreSQL using Spring Data JPA

í»  Tech Stack

Java 17+

Spring Boot 3+

Spring Web

Spring Data JPA

PostgreSQL

Maven

Docker (optional for containerized environment)

í³ Project Structure
```
microservice-users/
 â”œâ”€ src/
 â”‚  â”œâ”€ main/
 â”‚  â”‚  â”œâ”€ java/com/microstack/users/
 â”‚  â”‚  â”‚  â”œâ”€ controller/
 â”‚  â”‚  â”‚  â”œâ”€ service/
 â”‚  â”‚  â”‚  â”œâ”€ repository/
 â”‚  â”‚  â”‚  â”œâ”€ model/
 â”‚  â”‚  â”‚  â””â”€ UsersApplication.java
 â”‚  â”‚  â””â”€ resources/
 â”‚  â”‚     â””â”€ application.properties
 â”œâ”€ pom.xml
 â””â”€ Dockerfile
```
íº€ Running the Project
1. Configure PostgreSQL

Create a database:

CREATE DATABASE microstack_users;


Update application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/microstack_users
spring.datasource.username=postgres
spring.datasource.password=your_password

2. Run with Maven
mvn spring-boot:run


The service will start on:

http://localhost:8080

í³¡ Available Endpoints
Method	Endpoint	Description
GET	/users	Fetch all users
GET	/users/{id}	Get user by ID
POST	/users	Create a new user
DELETE	/users/{id}	Delete a user

Example payload for POST /users:

{
  "name": "John Doe",
  "email": "john.doe@example.com"
}

í·ª Testing

Use Postman, Insomnia, or curl:

curl http://localhost:8080/users

í°³ Docker Support (optional)

Build the image:

docker build -t microservice-users .


Run the container (requires PostgreSQL container or remote DB):

docker run -p 8080:8080 microservice-users

í´— Integration in the Microstack Architecture

This microservice is part of a larger polyglot architecture and integrates with:

Angular Frontend (via API Gateway)

Other backend services (Orders, Notifications, Inventory)

Centralized monitoring and logging (future stage)

í³ License

This project is open-source under the MIT License.
