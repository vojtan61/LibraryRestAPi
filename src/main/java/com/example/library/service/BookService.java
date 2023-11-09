package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book createBook(String author, String title, Integer year, Long isbn) {
        Book book = new Book(author, title, year, isbn);
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public Optional<Book> updateBook(Long bookId, Book bookDetails) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setAuthor(bookDetails.getAuthor());
            book.setTitle(bookDetails.getTitle());
            book.setIsbn(bookDetails.getIsbn());
            book.setYear(bookDetails.getYear());
            return Optional.of(bookRepository.save(book));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> getBookByTitle(String title) {
        Optional<Book> bookOptional = Optional.empty();
        Book book = bookRepository.findByTitle(title);
        if (book != null) {
            bookOptional = Optional.of(book);
        }
        return bookOptional;

    }

    public Optional<Book> getBookByYear(Integer year) {
        Optional<Book> bookOptional = Optional.empty();
        System.out.println(year);
        Book book = bookRepository.findByYear(year);
        System.out.println(book);
        if (book != null) {
            bookOptional = Optional.of(book);
        }
        return bookOptional;
    }

}
