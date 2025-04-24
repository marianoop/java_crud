package com.marianoop.library.services;

import com.marianoop.library.domain.entities.Book;

public interface BookService {

    Book createBook(String isbn, Book book);
}
