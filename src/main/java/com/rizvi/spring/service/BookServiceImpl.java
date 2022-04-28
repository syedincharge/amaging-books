package com.rizvi.spring.service;


import com.rizvi.spring.exception.ResourceNotFoundException;
import com.rizvi.spring.model.Author;
import com.rizvi.spring.model.Book;
import com.rizvi.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{


    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book getBookByIsbn(Integer id) {
        return bookRepository.getById(Long.valueOf(id));
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id",id));
    }

    @Override
    public Book getBooksByArthur(Author author) {
        return bookRepository.findBookByAuthor(author);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @Override
    public Book addBooks(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book editBooks(Book book, Long id) {

        Book existingBook  = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id",id));
        existingBook.setIsbn(book.getIsbn());
        existingBook.setTitle(book.getTitle());
        existingBook.setPublishedDate(book.getPublishedDate());
        existingBook.setIssuedCopies(book.getIssuedCopies());
        existingBook.setTotalCopies(book.getTotalCopies());
        existingBook.setAuthor(book.getAuthor());
        bookRepository.save(existingBook);
        return existingBook;

    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);


    }
}
