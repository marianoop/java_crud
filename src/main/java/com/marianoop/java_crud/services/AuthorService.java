package com.marianoop.java_crud.services;

import com.marianoop.java_crud.domain.entities.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    Author createAuthor(Author author);
}
