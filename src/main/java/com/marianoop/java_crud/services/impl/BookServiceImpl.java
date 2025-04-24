package com.marianoop.java_crud.services.impl;


import com.marianoop.java_crud.domain.entities.Book;
import com.marianoop.java_crud.repositories.BookRepository;
import com.marianoop.java_crud.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(String isbn, Book book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
