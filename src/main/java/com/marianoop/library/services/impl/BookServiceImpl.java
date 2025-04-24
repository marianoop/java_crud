package com.marianoop.library.services.impl;


import com.marianoop.library.domain.entities.Book;
import com.marianoop.library.repositories.BookRepository;
import com.marianoop.library.services.BookService;
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
