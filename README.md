# simple-library-system

This project implements a RESTful API for managing a simple library system. It allows users to register borrowers, register books, get a list of all books, borrow books, and return borrowed books.

## Technologies Used

- **Programming Language:** Java 17
- **Framework:** Spring Boot
- **Database:** H2(in-memory)
- **Package Manager:** Maven

## Running the Project

To run the project locally, follow these steps:

1. Clone the repository:

    ```bash
    git clone <repository-url>
    ```

2. Navigate to the project directory:

    ```bash
    cd simple-library-system
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    java -jar target/simple-library-system.jar
    ```

5. The API will be accessible at `http://localhost:8080`.

## API Documentation

API documentation can be found at [Swagger UI](http://localhost:8080/swagger-ui.html) after running the application.

## Assumptions

1. Each borrower has a unique identifier (`id`).
2. Each book has a unique identifier (`id`).
3. ISBN numbers uniquely identify books.
4. The system will allow two books with the same ISBN number have the same title and author.
5. The system will also allow multiple copies of books with the same ISBN number.
6. Only one borrower can borrow the same book at a time.
7. Proper data validation and error handling are implemented for all API endpoints.
8. Database schema will be automatically created based on the entity classes in Spring Boot with JPA.
9. Data will be seed as per `resources/data.sql` file.
10. Unit tests and unit test coverage are provided using JUnit and Mockito.
11. Clean code practices are followed to ensure readability and maintainability.
12. The project conforms to some principles of the 12 Factor Application methodology, including version control, declarative setup, and separation of configuration from code.