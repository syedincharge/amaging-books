package com.rizvi.spring.service;


import com.rizvi.spring.model.Author;
import com.rizvi.spring.model.Book;

import java.util.List;


public interface BookService {

     Book getBookByIsbn(Integer id);
     Book getBookById(Long id);
     Book getBooksByArthur(Author author);
     List<Book> getAllBooks();
     Book addBooks(Book book);
     Book editBooks(Book book, Long id);
     void deleteById(Long id);



}
