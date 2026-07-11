# URL Shortener

A modern Spring Boot REST API application that converts long URLs into short, shareable links with automatic redirection support.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)
- [Building & Running](#building--running)

## Features

- **URL Shortening**: Convert long URLs into compact short codes
- **Automatic Redirection**: Redirect short codes to original URLs with HTTP 301 (Moved Permanently)
- **Persistent Storage**: All shortened URLs are stored in PostgreSQL database
- **RESTful API**: Clean and intuitive REST endpoints
- **Data Validation**: URL validation to ensure only valid URLs are shortened
- **Efficient Lookup**: Fast retrieval of original URLs by short code

## Tech Stack

- **Framework**: Spring Boot 4.0.7
- **Language**: Java 25
- **ORM**: Spring Data JPA & Hibernate
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Additional Libraries**:
  - Lombok (reduces boilerplate code)
  - Spring MVC (REST endpoints)

## Prerequisites

- Java 25 or higher
- Maven 3.6+
- PostgreSQL 12+
- Git (optional)

## Installation

1. **Clone the repository** (or download the project):
   ```bash
   git clone <repository-url>
   cd urlShortener
   ```

2. **Install PostgreSQL** (if not already installed):
   - Download from [postgresql.org](https://www.postgresql.org/download/)
   - Create a new database named `url-shortner`
   - Default credentials: username: `postgres`, password: `postgres`

3. **Create the database**:
   ```bash
   createdb url-shortner
   ```

## Configuration

The application configuration is managed through `src/main/resources/application.properties`:

```properties
spring.application.name=urlShortener
spring.datasource.url=jdbc:postgresql://localhost:5432/url-shortner
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

**Update these values based on your PostgreSQL setup:**
- `spring.datasource.url`: PostgreSQL connection URL
- `spring.datasource.username`: Your PostgreSQL username
- `spring.datasource.password`: Your PostgreSQL password

## API Documentation

### 1. Create Shortened URL

**Endpoint**: `POST /shorten`

**Request**:
```bash
curl -X POST http://localhost:8080/shorten \
  -H "Content-Type: application/json" \
  -d "https://www.example.com/very/long/url/that/needs/shortening"
```

**Response**:
```json
{
  "shortCode": "abc123",
  "originalUrl": "https://www.example.com/very/long/url/that/needs/shortening",
  "shortUrl": "http://localhost:8080/abc123"
}
```

### 2. Redirect to Original URL

**Endpoint**: `GET /{shortCode}`

**Request**:
```bash
curl -L http://localhost:8080/abc123
```

**Response**: HTTP 301 Moved Permanently redirect to the original URL

## Project Structure

```
urlShortener/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/urlShortener/
│   │   │       ├── UrlShortenerApplication.java      # Main application entry point
│   │   │       ├── controller/
│   │   │       │   └── UrlController.java             # REST API endpoints
│   │   │       ├── dto/
│   │   │       │   └── ResponseDto.java               # API response model
│   │   │       ├── entity/
│   │   │       │   └── UrlEntity.java                 # Database entity
│   │   │       ├── repository/
│   │   │       │   └── UrlRepository.java             # Data access layer
│   │   │       ├── service/
│   │   │       │   └── UrlService.java                # Business logic
│   │   │       └── util/
│   │   │           └── UrlValidation.java             # URL validation utilities
│   │   └── resources/
│   │       └── application.properties                  # Configuration file
│   └── test/
│       └── UrlShortenerApplicationTests.java           # Unit tests
├── pom.xml                                             # Maven dependencies
├── README.md                                           # This file
└── HELP.md                                             # Additional help
```

## Building & Running

### Build the project:
```bash
mvn clean build
```

### Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Run tests:
```bash
mvn test
```

### Create an executable JAR:
```bash
mvn clean package
java -jar target/urlShortener-0.0.1-SNAPSHOT.jar
```

## Future Enhancements

- [ ] Custom short code generation
- [ ] URL analytics and click tracking
- [ ] Expiration dates for shortened URLs
- [ ] User authentication and authorization
- [ ] Rate limiting
- [ ] QR code generation for shortened URLs
- [ ] API key management




