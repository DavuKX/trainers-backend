# Trainers Backend

A Spring Boot REST API for managing Pokemon trainers, teams, and authentication.

## Overview

This backend service provides:
- Trainer registration and authentication (JWT-based)
- Team management
- Team-trainer associations
- Password reset via email
- Integration with a Pokemon teams service

## Tech Stack

- **Java 21**
- **Spring Boot 3.4.3** (Web, Data JPA, Security, Mail, WebFlux)
- **PostgreSQL** (hosted on Azure)
- **JWT** authentication (JJWT 0.11.5)
- **OpenAPI / Swagger UI** (springdoc 2.8.5)
- **Maven**

## API Endpoints

### Authentication (`/api/auth`)
| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/api/auth/register` | Register a new trainer |
| `POST` | `/api/auth/login` | Login and receive a JWT token |
| `GET` | `/api/auth/me` | Get the currently authenticated trainer |
| `POST` | `/api/auth/forgot-password` | Request a password reset email |
| `POST` | `/api/auth/reset-password` | Reset password using a reset token |

### Trainers (`/api/trainers`)
| Method | Path | Description |
|--------|------|-------------|
| `GET` | `/api/trainers` | List all trainers |
| `GET` | `/api/trainers/{id}` | Get a trainer by ID |
| `GET` | `/api/trainers/email/{email}` | Get a trainer by email |
| `PUT` | `/api/trainers/{id}` | Update a trainer |
| `DELETE` | `/api/trainers/{id}` | Delete a trainer |

### Teams (`/api/teams`)
| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/api/teams` | Create a new team |
| `GET` | `/api/teams/{id}` | Get a team by ID |
| `PUT` | `/api/teams/{id}` | Update a team |
| `DELETE` | `/api/teams/{id}` | Delete a team |

### Team-Trainers (`/api/team-trainers`)
| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/api/team-trainers` | Create a team-trainer association |
| `GET` | `/api/team-trainers/{id}` | Get a team-trainer by ID |
| `GET` | `/api/team-trainers/trainer/{trainerId}` | Get team-trainer by trainer ID |
| `PUT` | `/api/team-trainers/{id}` | Update a team-trainer |
| `DELETE` | `/api/team-trainers/{id}` | Delete a team-trainer |

## Getting Started

### Prerequisites

- Java 21
- Docker (for local PostgreSQL)
- Maven (or use the included `mvnw` wrapper)

### Run Locally

1. Start the PostgreSQL database:
   ```bash
   docker-compose up
   ```

2. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

3. The API will be available at `http://localhost:8080`
4. Swagger UI: `http://localhost:8080/swagger-ui.html`

### Build

```bash
./mvnw clean install
```

### Run Tests

```bash
./mvnw test
```

## Deployment

The application is deployed to **Azure Web App** via a GitHub Actions CI/CD pipeline that triggers on every push to the `main` branch.
