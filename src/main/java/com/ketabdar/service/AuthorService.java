package com.ketabdar.service;

import com.ketabdar.entity.Author;
import com.ketabdar.repository.AuthorRepository;

public class AuthorService {
    AuthorRepository authorRepository = new AuthorRepository();

    public void save(Author author){
        authorRepository.save(author);
    }

    public void load(int authorId){
        Author loadedAuthor = authorRepository.load(authorId);
        if (loadedAuthor != null) {
            System.out.println("Loaded author: " + loadedAuthor.getFirstName() + " " +
                    loadedAuthor.getLastName() + ", Age: " + loadedAuthor.getAge());
        } else {
            System.out.println("Author not found with ID: " + authorId);
        }
    }

}
