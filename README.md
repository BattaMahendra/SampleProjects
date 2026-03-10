
# 🚀 Microservices Project 🚀

This project is a demonstration of a microservices architecture using Spring Boot and Spring Cloud. It includes several microservices that work together to provide a comprehensive learning platform.

## ✨ Features

- **Service Discovery**: Using Netflix Eureka for service registration and discovery.
- **API Gateway**: Using Spring Cloud Gateway to route and protect the microservices.
- **Centralized Configuration**: Using Spring Cloud Config Server to manage the configuration for all the microservices.
- **Monitoring**: Using Spring Boot Admin Server to monitor the health and performance of the microservices.
- **Resilience**: Using Hystrix for fault tolerance and resilience.

## 🏛️ Architecture

The architecture of the project is as follows:

```
+-----------------+      +------------------+      +----------------------+
|                 |      |                  |      |                      |
|  Eureka Server  |<---->|   Config Server  |<---->|     Admin Server     |
|                 |      |                  |      |                      |
+-----------------+      +------------------+      +----------------------+
       ^                       ^                            ^
       |                       |                            |
       v                       v                            v
+-----------------+      +------------------+      +----------------------+
|                 |      |                  |      |                      |
|     Gateway     |<---->| Course-Catalog   |<---->|   course-info-serv   |
|                 |      |                  |      |                      |
+-----------------+      +------------------+      +----------------------+
                                 ^
                                 |
                                 v
                         +----------------------+
                         |                      |
                         | learner-ratings-serv |
                         |                      |
                         +----------------------+
```

## 🛠️ Technologies Used

- **Spring Boot**: For building the microservices.
- **Spring Cloud**: For service discovery, API gateway, and configuration management.
- **Netflix Eureka**: For service discovery.
- **Spring Cloud Gateway**: For API gateway.
- **Spring Cloud Config Server**: For centralized configuration.
- **Spring Boot Admin Server**: For monitoring.
- **Hystrix**: For fault tolerance.
- **Maven**: For dependency management.
- **Gradle**: For dependency management.
- **OAuth2.0**: For Security

## 🚀 Getting Started

To get started with the project, you will need to have the following installed:

- Java 8 or higher
- Maven
- Gradle

Once you have the prerequisites installed, you can clone the repository and run the services in the following order:

1. **Eureka Server**: `cd Eureka-Server-Gradle && ./gradlew bootRun`
2. **Config Server**: `cd config-server && ./mvnw spring-boot:run`
3. **Gateway**: `cd Gateway && ./mvnw spring-boot:run`
4. **Course-Catalog**: `cd Course-Catalog && ./mvnw spring-boot:run`
5. **course-info-serv**: `cd course-info-serv && ./mvnw spring-boot:run`
6. **learner-ratings-serv**: `cd learner-ratings-serv && ./mvnw spring-boot:run`
7. **Admin Server**: `cd adminserver && ./mvnw spring-boot:run`

## 🙏 Acknowledgements

This project was inspired by the many great resources available for learning about microservices, including the Spring documentation and various tutorials and blog posts.
