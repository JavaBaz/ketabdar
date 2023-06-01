package com.ketabdar.service;


import com.ketabdar.entity.Book;
import com.ketabdar.repository.BookRepository;

public class BookService {


    public void addBook(String bookName, int year, int authorId) {
        Book book = new Book(bookName, year, authorId);
        BookRepository.save(book);
        System.out.println("Book has been added to DataBase with following details :");
        System.out.println("Name : " + bookName + " | published Year : " + year + " | author id : " + authorId);
    }

    public static Book loadBook(int bookId) {
        return BookRepository.load(bookId);
    }

    public static void deleteBook(int bookId) {
        BookRepository.delete(bookId);
    }
}
