package com.ketabdar.service;

import com.ketabdar.entity.Author;
import com.ketabdar.repository.AuthorRepository;

public class AuthorService {
    AuthorRepository authorRepository = new AuthorRepository();

    public void save(Author author){
        authorRepository.save(author);
    }

}
