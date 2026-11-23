# BIT235 Assessment 2 — Part A: Wiki Administrator Login

**Name:** Guanzhang He
**Student ID:** S1580804

## Overview

A Spring Boot web application that implements the first stage of the Wiki system:
a login graphical user interface that authenticates the administrator's username
and password. There is **no database** in this stage; one acceptable account is
hard-coded in the repository layer.

## Hard-coded credentials

| Username      | Password |
|---------------|----------|
| `heguanzhang` | `123`    |

## Technology stack

- Java 17
- Spring Boot 3.3.5 (Spring MVC, embedded Tomcat)
- Thymeleaf (View layer)
- Maven

## MVC / layered structure

```
src/main/java/com/bit235/wiki
├── WikiApplication.java          // Application entry point
├── controller
│   └── LoginController.java        // Request handling: GET /login, POST /login
├── service
│   └── LoginService.java          // Business logic: credential validation
├── repository
│   └── UserRepository.java       // Data access: hard-coded accepted account
└── model
    └── User.java                  // Model: username / password form backing object

src/main/resources
├── application.properties
├── templates
│   ├── login.html                 // Login form view
│   ├── welcome.html               // Success view
│   └── error.html                 // Failure view
└── static/css/style.css            // Shared stylesheet
```

## How to run

1. Make sure JDK 17 and Maven are installed.
2. In the project root, run:

   ```bash
   mvn spring-boot:run
   ```

3. Open <http://localhost:8080> in a browser.
4. Log in with `heguanzhang` / `123` (success → welcome page); any other
   combination shows the error page.

## Request flow

1. Browser sends `GET /login` → controller returns the login form.
2. Form submits `POST /login` with username and password.
3. Controller passes the credentials to `LoginService.authenticate(...)`.
4. Service compares them with the account from `UserRepository`.
5. Match → `welcome` page; no match → `error` page.
