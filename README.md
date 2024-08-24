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
- Docker (optional, for containerized deployment)

## Installation

### Clone the Repository
1. Clone the repository to your local machine:
   ```sh
   git clone https://github.com/muradul93/quick-cart.git
   cd quick-cart
   ```

### Build the Project
2. Build the project using Maven:
   ```sh
   mvn clean package
   ```

### Configure the Database
3. By default, the application is configured to use a MySQL database. Ensure the `application.properties` file is updated with your MySQL database credentials:
   ```properties
   # MySQL Database configuration
   spring.datasource.url=jdbc:mysql://localhost:3306/quickcart_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
   ```

### Load Initial Data
4. To load initial data into the database, ensure the `data.sql` file is present in the `src/main/resources` directory. Spring Boot will automatically execute this script on application startup.

 ### or
 To load initial data into the database, run the following script manually:
   ```sh
   mysql -u root -p quickcart_db < src/main/resources/data.sql
   ```

### Run the Application
5. Run the application:
   ```sh
   mvn spring-boot:run
   ```

6. The application will be available at `http://localhost:8080`.

### Running Tests
7. Run the tests:
   ```sh
   mvn test
   ```

### Building and Running with Docker
8. Build the Docker image:
   ```sh
   docker build -t quickcart .
   ```

9. Run the Docker container:
   ```sh
   docker run -p 8080:8080 quickcart
   ```