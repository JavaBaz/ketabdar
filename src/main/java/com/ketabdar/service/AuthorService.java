package com.ketabdar.service;

import com.ketabdar.entity.Author;
import com.ketabdar.repository.AuthorRepository;

public class AuthorService {
    static AuthorRepository authorRepository = new AuthorRepository();

    public void save(Author author){
        authorRepository.save(author);
    }

    public static Author load(int authorId) {
        Author loadedAuthor = authorRepository.load(authorId);
        if (loadedAuthor != null) {
            System.out.println("Loaded author: " + loadedAuthor.getFirstName() + " " +
                    loadedAuthor.getLastName() + ", Age: " + loadedAuthor.getAge());

            String[] bookTitles = loadedAuthor.getBookTitles();
            System.out.println("Author's book titles:");
            for (String title : bookTitles) {
                System.out.println("- " + title);
            }

        }
        return loadedAuthor;
    }

}
