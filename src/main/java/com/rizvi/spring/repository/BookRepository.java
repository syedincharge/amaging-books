package com.rizvi.spring.repository;

import com.rizvi.spring.model.Author;
import com.rizvi.spring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByAuthor(Author author);
}
