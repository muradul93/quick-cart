# QuickCart

QuickCart is an e-commerce application built with Spring Boot, Maven, and Docker. It provides functionalities for managing customers, items, sales, and wishlists.

## Features
- Customer management
- Item management
- Sales tracking
- Wishlist management
- RESTful API

## Prerequisites
- Java 17
- Maven
- Docker

## Installation

### Clone the Repository
1. Clone the repository:
   ```sh
   git clone https://github.com/muradul93/quick-cart.git
   cd quick-cart


### Build the Project
2. Build with Maven:
   ```sh
   mvn clean package
   ```

### Configure the Database
3. Update `application.properties` with your MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://db:3306/quickcart_db?useSSL=false&allowPublicKeyRetrieval=true
   spring.datasource.username=root
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
   ```

### Load Initial Data
4. Ensure `data.sql` is in `src/main/resources` for initial data load.

### Running with Docker
5. Build and run with Docker Compose:
   ```sh
   docker-compose up --build
   ```

6. Access the app at `http://localhost:8081`.

### Accessing MySQL UI Tools
7. Access phpMyAdmin at `http://localhost:8082`.

### Running Tests
8. Run tests:
   ```sh
   mvn test
   ```