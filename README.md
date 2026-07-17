# Dockerized E-Commerce Microservices

A production-style E-Commerce backend built using **Spring Boot Microservices**, **Spring Cloud**, **Docker**, and **PostgreSQL**. The project demonstrates service discovery, centralized configuration, API Gateway routing, and containerized deployment using Docker Compose.

---

## Features

- Microservices Architecture
- Spring Boot 3
- Spring Cloud Config Server
- Eureka Service Discovery
- Spring Cloud Gateway
- PostgreSQL Database
- Docker & Docker Compose
- RESTful APIs
- Maven Build

---

## Project Structure

```
ecommerce-microservices-docker
│
├── api-gateway
├── config-server
├── eureka-server
├── user-service
├── product-service
├── order-service
├── docker-compose.yml
└── README.md
```

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Cloud
- Spring Cloud Gateway
- Eureka Server
- Config Server
- PostgreSQL
- Maven
- Docker
- Docker Compose
- Git & GitHub

---

## Architecture

```
                    Client
                       |
                 API Gateway
                       |
      -----------------------------------
      |              |                 |
 User Service   Product Service   Order Service
      |              |                 |
 PostgreSQL     PostgreSQL       PostgreSQL
             \      |      /
              Eureka Server
                    |
             Config Server
```

---

## Services

| Service | Default Port |
|---------|--------------|
| API Gateway | 8080 |
| User Service | 8081 |
| Product Service | 8082 |
| Order Service | 8083 |
| Eureka Server | 8761 |
| Config Server | 8888 |

---

## Prerequisites

Before running the project, install:

- Java 17
- Maven
- Docker Desktop
- Git

---

## Build the Project

Run the following command inside each microservice:

```bash
mvn clean package -DskipTests
```

---

## Run with Docker

From the project root:

```bash
docker-compose up --build
```

To stop the project:

```bash
docker-compose down
```

To start again:

```bash
docker-compose up
```

---

## Access the Application

### Eureka Dashboard

```
http://localhost:8761
```

### API Gateway

```
http://localhost:8080
```

---

## Sample API Endpoints

### User Service

```
POST /api/users
GET /api/users
```

### Product Service

```
POST /api/products
GET /api/products
```

### Order Service

```
POST /api/orders
GET /api/orders
```

---

## Docker Overview

Each microservice is packaged as a Docker image using its own Dockerfile.

Docker Compose is used to:

- Start PostgreSQL
- Start Eureka Server
- Start Config Server
- Start API Gateway
- Start all Microservices
- Create a common Docker network
- Manage dependencies between services

---

## Screenshots

Add screenshots here after running the project.

Example:

```
screenshots/
├── docker-containers.png
├── eureka-dashboard.png
└── postman-api.png
```

---

## Future Enhancements

- JWT Authentication
- Spring Security
- Kafka Integration
- Kubernetes Deployment
- CI/CD Pipeline using GitHub Actions
- Monitoring with Prometheus & Grafana

---

## Author

**Kalaiselvi A**

- Java Backend Developer
- Spring Boot | Microservices | Docker | PostgreSQL

GitHub:
https://github.com/Kalaiselvi-A

LinkedIn:
https://www.linkedin.com/in/kalaiselvia/