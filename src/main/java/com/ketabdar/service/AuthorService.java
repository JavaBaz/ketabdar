package com.ketabdar.service;

import com.ketabdar.entity.Author;
import com.ketabdar.repository.AuthorRepository;

public class AuthorService {
    static AuthorRepository authorRepository = new AuthorRepository();

    public void register(String firstname, String lastname, int age) {
        Author author = new Author(firstname, lastname, age);
        authorRepository.save(author);
        System.out.println("Author registration  with following detail is completed !");
        System.out.print("Full name : " + firstname + " " + lastname + " | " + " age : " + age);
        authorRepository.lastRegistered();
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
