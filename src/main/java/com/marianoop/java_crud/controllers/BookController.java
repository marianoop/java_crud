package com.marianoop.java_crud.controllers;

import com.marianoop.java_crud.domain.dtos.BookDto;
import com.marianoop.java_crud.domain.entities.Book;
import com.marianoop.java_crud.mappers.Mapper;
import com.marianoop.java_crud.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;
    private final Mapper<Book, BookDto> bookMapper;

    public BookController(BookService bookService, Mapper<Book, BookDto> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto
    ) {
        Book bookEntity =  bookMapper.mapFrom(bookDto);
        Book savedBookEntity = bookService.createBook(isbn, bookEntity);

        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity),HttpStatus.CREATED);
    }
}
