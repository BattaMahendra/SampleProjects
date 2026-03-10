# 🚀 Java Mastery & Microservices Lab

Welcome to the **Java Mastery & Microservices Lab**! This repository is designed to simplify Java learning for beginners while providing advanced architectural patterns for experienced professionals. Whether you're preparing for interviews or building scalable systems, this project has something for you.

## 🌟 Project Overview

This project is a comprehensive collection of:
- **Microservices Architecture**: A full-fledged ecosystem with Service Discovery, API Gateway, Config Server, and Monitoring.
- **Core Java Concepts**: Deep dives into functional programming, design patterns, and data structures.
- **Security Implementations**: OAuth 2.0 integration with Okta.

---

## 🏗️ Architecture

Below is the high-level architecture of the microservices ecosystem included in this project.

```mermaid
graph TD
    Client[Client App] --> Gateway[API Gateway]
    Gateway --> Auth[OAuth2 / Security]
    Gateway --> ServiceA[Course Catalog Service]
    Gateway --> ServiceB[Course Info Service]
    Gateway --> ServiceC[Learner Ratings Service]
    
    ServiceA --> Eureka[Eureka Discovery Server]
    ServiceB --> Eureka
    ServiceC --> Eureka
    Gateway --> Eureka

    ServiceA --> Config[Config Server]
    ServiceB --> Config
    ServiceC --> Config
    Gateway --> Config
    
    Admin[Admin Server] -.-> ServiceA
    Admin -.-> ServiceB
    Admin -.-> ServiceC
    
    subgraph "Core Learning Modules"
        SpringDemo[Spring Demo (Java Core)]
        TestEclipse[Test Eclipse (OAuth2 Resource Server)]
    end
```

---

## 📦 Modules & Key Learnings

### 1. ☕ Spring Demo (Core Java & Patterns)
*Master the fundamentals and advanced concepts of Java.*

This module is a treasure trove for interview preparation, covering:
- **Functional Programming**: 
  - `JavaClosure.java`: Understanding closures in Java.
  - `HigherOrderFunction.java`: Functions that take or return other functions.
  - `TailCallOptimization.java`: Optimizing recursion.
  - `MethodReference.java`: Cleaner code with method references.
- **Design Patterns**:
  - **Builder Pattern**: Constructing complex objects step-by-step.
  - **Decorator Pattern**: Adding behavior to objects dynamically.
- **Data Structures**: Practical examples with Arrays, Strings, and Bytes.

### 2. 🔒 Test Eclipse (OAuth 2.0 Security)
*Secure your APIs like a pro.*

A dedicated module demonstrating **OAuth 2.0 Resource Server** implementation:
- **Okta Integration**: Secures endpoints using Okta as the Authorization Server.
- **Token Validation**: Validates JWT access tokens for secure API access.
- **Spring Security**: Configures `HttpSecurity` to require authentication for specific routes.

### 3. 🌐 Microservices Ecosystem
*Build scalable, distributed systems.*

- **Gateway**: The entry point for all client requests, handling routing and cross-cutting concerns.
- **Eureka Server**: Service registry for dynamic discovery of microservices.
- **Config Server**: Centralized configuration management for all services.
- **Admin Server**: Spring Boot Admin for monitoring application health and metrics.
- **Domain Services**:
  - `Course-Catalog`: Manages course listings.
  - `course-info-serv`: Provides detailed course information.
  - `learner-ratings-serv`: Handles user ratings and feedback.

### 4. 🗄️ Database Integration
- **Spring Boot H2 Example**: A quick-start guide to using H2 in-memory database with Spring Boot.

---

## 🚀 Getting Started

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/SampleProjects.git
    ```
2.  **Build the projects**:
    Most modules are Maven-based. Navigate to the directory and run:
    ```bash
    ./mvnw clean install
    ```
    *(Note: `Eureka-Server-Gradle` uses Gradle)*
3.  **Run the Infrastructure**:
    - Start **Eureka Server** first.
    - Start **Config Server**.
    - Start **Gateway**.
    - Start **Admin Server**.
4.  **Run the Services**:
    - Start the domain services (`Course-Catalog`, etc.).

---

## 🤝 Contribution

Feel free to fork this repository and submit pull requests. Whether it's fixing a bug, adding a new design pattern, or improving documentation, your contributions are welcome!

---

*Created with ❤️ for the Java Community.*
