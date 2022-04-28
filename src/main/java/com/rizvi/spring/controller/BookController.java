package com.rizvi.spring.controller;


import com.rizvi.spring.model.Author;
import com.rizvi.spring.model.Book;
import com.rizvi.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController  {

    @Autowired
    private BookService bookService;


    @PostMapping("/add")
    public Book addBooks(@RequestBody Book book) {
        return bookService.addBooks(book);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllStudents() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<Book>(bookService.getBookById(bookId), HttpStatus.OK);


    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long bookId) {

        bookService.deleteById(bookId);

        return new ResponseEntity<String>("Book deleted successfully!! ", HttpStatus.OK);
    }

    @PatchMapping("update/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) {

        return new ResponseEntity<Book>(bookService.editBooks(book,  bookId), HttpStatus.OK);
    }


    @GetMapping("/author/{author}")
    public Book findByEmailId (@PathVariable("author") Author authors){
        return  bookService.getBooksByArthur(authors);

    }

}
