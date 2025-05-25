
# Library Management System

A Spring Boot backend for managing library operations with user registration, book management, and borrowing functionality.

## Features

- **Book Management**
  - Add new books to inventory (`POST /api/addbook`)
  - View all available books (`GET /api/books`)
  
- **User System**
  - Register new members (`POST /api/register`)
    - Passwords stored securely using BCrypt hashing
  - User login validation (`POST /api/login`)
    - Verifies credentials against hashed passwords

- **Borrowing System**
  - Borrow books (`POST /api/borrow`)
  - Return books with auto-fine calculation (`PATCH /api/return`)
    - Fines: ₹10/day after 14-day borrowing period

## Tech Stack

- **Backend**: Java 17, Spring Boot 3.x
- **Database**: MySQL 8+
- **ORM**: Spring Data JPA
- **Security**: BCrypt password hashing
- **Testing**: Postman

## API Endpoints

| Endpoint                | Method | Description                      | Request Param Example                |
|-------------------------|--------|----------------------------------|-------------------------------------|
| `/api/signup`           | POST   | Register new user                | name- John , email - john@example.com , password - 1234 |
| `/api/login`            | POST   | Validate credentials             | email - john@example.com , password - 1234 |
| `/api/addbook`          | POST   | Add new book                     | title - Clean Code , author - Robert Martin , isbn - 9780132350884 , quantity - 5 |
| `/api/books`            | GET    | List all books                   | - |
| `/api/borrow`           | POST   | Borrow a book                    | bookId- 1 , userId - 1 |
| `/api/return`           | PATCH  | Return a book                    | - recordId   -  1|

## Database Schema

```sql
CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    quantity INT NOT NULL
);

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL  /* BCrypt hashed */
);

CREATE TABLE borrow_records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    borrow_date DATE NOT NULL,
    return_date DATE,
    fine DECIMAL(10,2),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
