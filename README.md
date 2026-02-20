# 🏦 Banking App

A RESTful banking API built with **Java Spring Boot**, designed to handle secure financial operations between user accounts. The application provides a clean and reliable interface for managing accounts, processing transactions, and handling errors gracefully.

## Features

- **Account Management** — Create and manage user bank accounts
- **Transaction Processing** — Handle financial transfers between accounts with consistency and reliability
- **Error Handling** — Robust error management ensuring meaningful feedback and safe operations
- **RESTful API** — Clean REST endpoints following standard HTTP conventions

## Tech Stack

- **Java** with **Spring Boot**
- **Maven** for dependency management and build lifecycle
- **Spring Data JPA** for persistence
- **Spring Web** for REST API layer

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+

### Installation

```bash
# Clone the repository
git clone https://github.com/MartingLenoirDiego/BankingApp.git
cd BankingApp

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

## API Overview

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/accounts` | Create a new account |
| `GET` | `/accounts/{id}` | Retrieve account details |
| `POST` | `/transactions` | Process a transaction |
| `GET` | `/transactions/{id}` | Get transaction details |

> Endpoints may vary, refer to the source code for the full list.

## Project Structure

```
src/
└── main/
    └── java/
        └── com/bankingapp/
            ├── controller/    # REST controllers
            ├── service/       # Business logic
            ├── repository/    # Data access layer
            └── model/         # Entity definitions
```

## Author

**Diego Marting Lenoir**  
[GitHub](https://github.com/MartingLenoirDiego)
