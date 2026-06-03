### Student Management System – Spring Boot JWT Secure API

A secure and scalable Student Management System REST API built with Spring Boot, Spring Security, and JWT authentication, using MySQL as the database.
#  Tech Stack
- Backend: Spring Boot
- Security: Spring Security + JWT (jjwt)
- Database: MySQL
- ORM: Spring Data JPA / Hibernate
- 
## Features

# Authentication
- User Registration (/api/auth/register)
- User Login with JWT Token (/api/auth/login)
- Password encryption using BCrypt
#  Student Management (Protected APIs)
- Create Student
- Get All Students
- Update Student
- Delete Student
- Search by Name (case-insensitive)
- Search by Department (case-insensitive)
#  Security
- JWT-based stateless authentication
- Spring Security configured with:
- CSRF disabled
- Session management: STATELESS
- Protected endpoints require valid JWT token
- Public endpoints: /api/auth/**
#  Exception Handling
- Global exception handling using GlobalExceptionHandler
- Proper validation error responses using @Valid and @NotBlank
