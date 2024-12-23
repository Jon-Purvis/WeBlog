# Weblog - Blog Platform

## Project Description

Weblog is a blog platform built using Java, Maven, PostgreSQL, and BCrypt for secure authentication. It follows a layered architecture that separates concerns into three key areas: data access, business logic, and presentation logic. This architecture is achieved using **DAOs** (Data Access Objects), **service facades**, and **presenters** to ensure code modularity and maintainability.

### Key Features:
- **Authentication**: Secure login and registration functionality using **BCrypt** encryption.
- **User Interactions**: 
  - Users can follow bloggers.
  - View, comment on, and like blogs.
- **Data Management**: Utilizes **PostgreSQL** with **JDBC** for efficient data retrieval and management.
- **Clean Architecture**: Layered architecture with separation of concerns for maintainability and scalability.

---

## Project Structure

```
├── compose.yaml              # Docker Compose configuration file
├── pom.xml                   # Maven project file for dependencies
├── README.md                 # Project documentation (this file)
├── src/                      # Source code
│   ├── main/java/com/weblog  # Java source code
│   │   ├── database/         # DAO implementations
│   │   ├── entity/           # Entity classes representing the data model
│   │   ├── service/          # Business logic (service facades)
│   │   ├── ui/               # Presentation layer (presenters and views)
│   │   └── utility/          # Utility classes (e.g., PasswordEncryptor)
│   └── test/java/com/weblog  # Unit tests for the application
└── target/                   # Compiled classes and resources
```

---

## Technologies Used

- **Java**: Core language for backend logic.
- **Maven**: Build automation tool for managing dependencies and building the project.
- **PostgreSQL**: Relational database used for data storage and management.
- **BCrypt**: Secure hashing algorithm for password storage and validation.
- **JDBC**: Java Database Connectivity for interacting with PostgreSQL.
- **Docker**: For containerizing the application and running database server with `compose.yaml`.

---

## Setup and Installation

### Prerequisites

Before running the application, make sure you have the following installed:

- **Java 8 or higher**
- **Maven**
- **Docker** (optional, if you wish to use Docker Compose)
- **PostgreSQL** (or you can use the provided Docker Compose configuration)

### Steps to Run the Application Locally

1. **Clone the repository**:
   ```
   git clone https://github.com/Jon-Purvis/weblog.git
   cd weblog
   ```

2. **Build the project**:
   - Using Maven:
     ```
     mvn clean install
     ```

3. **Configure PostgreSQL**:
   - If you don't have PostgreSQL set up, create a database called `weblog`.
   - Alternatively, you can use the provided `compose.yaml` to run the database in Docker.
   ```
   docker-compose up -d
   docker exec -it weblog-db psql -U postgres
   CREATE DATABASE db;
   CREATE USER username WITH PASSWORD 'password';
   GRANT ALL PRIVILEGES ON DATABASE db TO username;
   ```

   ```
   docker exec -it weblog-db psql -U username -d db
   \i /src/main/java/com/weblog/database/table.s
   ```

4. **Run the application**:
   - Once the project is built and the database is set up, run the application:
     ```
     mvn exec:java
     ```



## Features and Usage

### Authentication:
- Users can sign up by creating an account with a username and password.
- Passwords are stored securely using **BCrypt** hashing.
- Users can log in using their credentials.

### Blog Features:
- Users can read, post, comment on, and like blogs.
- Bloggers can interact with readers, with support for following other bloggers.

---

## Future Improvements

- Enhance the UI for a better user experience.

---

