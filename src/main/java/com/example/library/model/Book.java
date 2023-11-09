package com.example.library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books", schema = "BOOK_APP")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookID")
    private Long id;

    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "year")
    private Integer year;
    @Column(name = "isbn")
    private Long isbn;

    public Book(Long id, String author, String title, Integer year, Long isbn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }

    public Book(String author, String title, Integer year, Long isbn) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
