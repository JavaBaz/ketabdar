package com.ketabdar;

import com.ketabdar.entity.Author;
import com.ketabdar.entity.Book;
import com.ketabdar.service.AuthorService;
import com.ketabdar.service.BookService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        AuthorService authorService = new AuthorService();
//        Author author = new Author();

//        System.out.print("Enter your first name : ");
//        author.setFirstName(scanner.nextLine());
//        System.out.print("Enter your last name : ");
//        author.setLastName(scanner.nextLine());
//        System.out.print("Enter Your age : ");
//        author.setAge(scanner.nextInt());

          // save an author
//        authorService.save(author);


        // load an author
//        authorService.load(8);
        System.out.println("-----");




        // Create a book
//        Book book2 = new Book();
//        book2.setTitle("Book to delete 1");
//        book2.setAuthorId(6);
//        book2.setYearOfPublication(2021);
//
//
//        // Save the book
//        System.out.println("---Save the book---");
//        BookService bookService = new BookService();
//        bookService.saveBook(book2);
//
//
//
//        System.out.println("---Load the book---");
//        System.out.println(BookService.loadBook(3));
//        System.out.println();


        System.out.println("---Delete the book---");
        BookService.deleteBook(7);



    }
}