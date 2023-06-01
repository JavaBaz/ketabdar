package com.ketabdar;

import com.ketabdar.entity.Author;
import com.ketabdar.repository.AuthorRepository;
import com.ketabdar.service.AuthorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AuthorService authorService = new AuthorService();
        Author author = new Author();

//        System.out.print("Enter your first name : ");
//        author.setFirstName(scanner.nextLine());
//        System.out.print("Enter your last name : ");
//        author.setLastName(scanner.nextLine());
//        System.out.print("Enter Your age : ");
//        author.setAge(scanner.nextInt());

//        authorService.save(author);

        System.out.println("-----");
        authorService.load(8);


    }
}