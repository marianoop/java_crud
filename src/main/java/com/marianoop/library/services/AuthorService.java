package com.marianoop.library.services;

import com.marianoop.library.domain.entities.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    Author createAuthor(Author author);
}
