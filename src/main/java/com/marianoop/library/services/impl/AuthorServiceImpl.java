package com.marianoop.library.services.impl;

import com.marianoop.library.domain.entities.Author;
import com.marianoop.library.repositories.AuthorRepository;
import com.marianoop.library.services.AuthorService;
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
