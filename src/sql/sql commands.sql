CREATE DATABASE ketabdar;


DROP TABLE IF EXISTS authors CASCADE;
DROP TABLE IF EXISTS publishers CASCADE;
DROP TABLE IF EXISTS book_categories CASCADE;
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS comments CASCADE;
DROP TABLE IF EXISTS loans CASCADE;
DROP TABLE IF EXISTS reservations CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS ratings CASCADE;
DROP TABLE IF EXISTS book_history CASCADE;

CREATE TABLE roles
(
    role_id   SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE authors
(
    author_id SERIAL PRIMARY KEY,
    name      VARCHAR(100) NOT NULL,
    biography TEXT,
    birthdate DATE
);

CREATE TABLE publishers
(
    publisher_id SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    address      TEXT,
    phone        VARCHAR(15)
);

CREATE TABLE book_categories
(
    category_id   SERIAL PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE books
(
    book_id          SERIAL PRIMARY KEY,
    title            VARCHAR(200)       NOT NULL,
    isbn             VARCHAR(13) UNIQUE NOT NULL,
    publication_year INT,
    copies           INT DEFAULT 0,
    publisher_id     INT REFERENCES publishers (publisher_id) ON DELETE SET NULL,
    category_id      INT REFERENCES book_categories (category_id) ON DELETE SET NULL,
    author_id        INT REFERENCES authors (author_id) ON DELETE SET NULL
);

CREATE TABLE users
(
    user_id           SERIAL PRIMARY KEY,
    role_id           INT REFERENCES roles (role_id) ON DELETE SET NULL,
    username          VARCHAR(50) UNIQUE  NOT NULL,
    password          VARCHAR(255)        NOT NULL,
    email             VARCHAR(100) UNIQUE NOT NULL,
    full_name         VARCHAR(100),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE comments
(
    comment_id   SERIAL PRIMARY KEY,
    user_id      INT REFERENCES users (user_id) ON DELETE CASCADE,
    book_id      INT REFERENCES books (book_id) ON DELETE CASCADE,
    comment_text TEXT NOT NULL,
    comment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE loans
(
    loan_id       SERIAL PRIMARY KEY,
    user_id       INT REFERENCES users (user_id) ON DELETE CASCADE,
    book_id       INT REFERENCES books (book_id) ON DELETE CASCADE,
    loan_date     TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    return_date   TIMESTAMP,
    return_status VARCHAR(20)    DEFAULT 'on time',
    late_fee      DECIMAL(10, 2) DEFAULT 0.00
);

CREATE TABLE reservations
(
    reservation_id   SERIAL PRIMARY KEY,
    user_id          INT REFERENCES users (user_id) ON DELETE CASCADE,
    book_id          INT REFERENCES books (book_id) ON DELETE CASCADE,
    reservation_date TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    status           VARCHAR(20) DEFAULT 'pending'
);

CREATE TABLE ratings
(
    rating_id   SERIAL PRIMARY KEY,
    user_id     INT REFERENCES users (user_id) ON DELETE CASCADE,
    book_id     INT REFERENCES books (book_id) ON DELETE CASCADE,
    rating      INT CHECK (rating >= 1 AND rating <= 5),
    review      TEXT,
    rating_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE book_history
(
    history_id  SERIAL PRIMARY KEY,
    book_id     INT REFERENCES books (book_id) ON DELETE CASCADE,
    user_id     INT REFERENCES users (user_id) ON DELETE CASCADE,
    action      VARCHAR(50) NOT NULL,
    action_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_books_isbn ON books (isbn);