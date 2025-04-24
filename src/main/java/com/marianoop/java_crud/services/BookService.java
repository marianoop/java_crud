package com.marianoop.java_crud.services;

import com.marianoop.java_crud.domain.entities.Book;

public interface BookService {

    Book createBook(String isbn, Book book);
}
