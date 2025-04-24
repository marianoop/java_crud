package com.marianoop.java_crud.services.impl;

import com.marianoop.java_crud.domain.entities.Author;
import com.marianoop.java_crud.repositories.AuthorRepository;
import com.marianoop.java_crud.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}
