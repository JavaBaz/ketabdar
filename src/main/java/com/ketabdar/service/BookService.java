package com.ketabdar.service;


import com.ketabdar.entity.Book;
import com.ketabdar.repository.BookRepository;

public class BookService {


    public void saveBook(Book book) {
        BookRepository.save(book);
    }

    public static Book loadBook(int bookId) {
        return BookRepository.load(bookId);
    }

    public static void deleteBook(int bookId) {
        BookRepository.delete(bookId);
    }
}
