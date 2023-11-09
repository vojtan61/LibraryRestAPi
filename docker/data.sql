CREATE DATABASE IF NOT EXISTS BOOK_APP;

USE BOOK_APP;

SET NAMES UTF8;

CREATE TABLE books(
    bookID BIGINT NOT NULL AUTO_INCREMENT,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    isbn BIGINT NOT NULL,
    PRIMARY KEY (bookID)
);

INSERT INTO books(author, title, year, isbn) VALUES ('J.K. Rowling', 'Harry Potter a Kámen mudrců', 1997, 9780747532748);
INSERT INTO books(author, title, year, isbn) VALUES ('J.R.R. Tolkien', 'Pán prstenů: Společenstvo Prstenu', 1954, 9780006994119);
INSERT INTO books(author, title, year, isbn) VALUES ('Harper Lee', 'Jako zabít ptáčka', 1960, 9780060914200);
INSERT INTO books(author, title, year, isbn) VALUES ('George R.R. Martin', 'Hra o trůny', 1996, 9780553573400);
INSERT INTO books(author, title, year, isbn) VALUES ('Leo Tolstoy', 'Vojna a mír', 1869, 9780679602661);
INSERT INTO books(author, title, year, isbn) VALUES ('J.K. Rowling', 'Harry Potter a Relikvie smrti', 2007, 9780747591074);