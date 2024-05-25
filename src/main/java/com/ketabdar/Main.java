package com.ketabdar;


import com.ketabdar.service.AuthorService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        BookService bookService = new BookService();

        AuthorService authorService = new AuthorService();

//         save an author
        authorService.register("Amin","Test", new Date());


        // load an author
//        AuthorService.load("Amin");


//        System.out.println("-----");
//        bookService.addBook("test5", 2017, 6);

        // Create a book
//        Book book2 = new Book();
//        book2.setTitle("Book to delete 1");
//        book2.setAuthorId(6);
//        book2.setYearOfPublication(2021);

        // Save the book
//        System.out.println("---Save the book---");
//        BookService bookService = new BookService();
//        bookService.saveBook(book2);

        // Load the book
//        System.out.println("---Load the book---");
//        System.out.println(BookService.loadBook(3));
//        System.out.println();

        // Delete the book
//        System.out.println("---Delete the book---");
//        BookService.deleteBook(7);


    }
}