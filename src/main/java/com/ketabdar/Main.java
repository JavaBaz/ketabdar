package com.ketabdar;

import com.ketabdar.entity.Author;
import com.ketabdar.entity.Book;
import com.ketabdar.service.AuthorService;
import com.ketabdar.service.BookService;

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
        System.out.println("-----");




        // Create a book
//        Book book = new Book();
//        book.setTitle("Book 1");
//        book.setAuthorId(6);
//        book.setYearOfPublication(2021);
//
//        System.out.println("---Save the book---");
//
//        // Save the book
//        BookService bookService = new BookService();
//        bookService.saveBook(book);




        System.out.println("---Load the book---");
        Book loadedBook = BookService.loadBook(1);
        System.out.println(loadedBook);

    }
}