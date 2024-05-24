package com.ketabdar.service;

import com.ketabdar.entity.Author;
import com.ketabdar.repository.AuthorRepository;

import java.util.Date;

public class AuthorService {
    static AuthorRepository authorRepository = new AuthorRepository();

    public String register(String name, String biography, Date birthdate) {
        Author author = new Author(name, biography, birthdate);
        authorRepository.save(author);
        System.out.println("Author registration with the following details is completed!");
        System.out.println("Name: " + name + " | Biography: " + biography + " | Birthdate: " + birthdate);

        return "TEST";
    }

    public static Author load(String authorName) {
        Author loadedAuthor = authorRepository.load(authorName);
        if (loadedAuthor != null) {
            System.out.println("Loaded author: " + loadedAuthor.getName() +
                    ", Biography: " + loadedAuthor.getBiography() +
                    ", Birthdate: " + loadedAuthor.getBirthdate());

            String[] bookTitles = loadedAuthor.getBookTitles();
            System.out.println("Author's book titles:");
            for (String title : bookTitles) {
                System.out.println("- " + title);
            }
        }
        return loadedAuthor;
    }

    public static void closeRepository() {
        authorRepository.close();
    }
}