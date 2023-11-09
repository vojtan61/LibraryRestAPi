package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books/create/json", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PostMapping(value = "/books/create/params")
    public Book createBook(@RequestParam String author, @RequestParam String title, @RequestParam Integer year, @RequestParam Long isbn) {
        return bookService.createBook(author, title, year, isbn);
    }

    @RequestMapping(value = "books/detail/{bookId}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@PathVariable(value = "bookId") Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).build());

    }

    @RequestMapping(value="/books/{bookId}", method=RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable(value = "bookId") Long id, @RequestBody Book bookDetails) {
        Optional<Book> optionalBook = bookService.updateBook(id, bookDetails);
        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("books/all")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping(value="/books/{bookId}", method=RequestMethod.DELETE)
    public void deleteBook(@PathVariable(value = "bookId") Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/books/year")
    public ResponseEntity<Book> getBookByYear(@RequestParam Integer year) {
        Optional<Book> book = bookService.getBookByYear(year);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/books/title")
    public ResponseEntity<Book> getBookByTitle(@RequestParam String title) {
        Optional<Book> book = bookService.getBookByTitle(title);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.status(404).build();
    }

}
