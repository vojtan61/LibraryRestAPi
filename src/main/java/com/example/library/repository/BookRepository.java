package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Book findByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE b.year = :year")
    Book findByYear(@Param("year") Integer year);

    @Query("SELECT b FROM Book b WHERE b.isbn = :isbn")
    Book findByIsbn(@Param("isbn") Long isbn);

    @Query("SELECT b FROM Book b WHERE b.author = :author")
    Book findByAuthor(@Param("author") String author);

}
