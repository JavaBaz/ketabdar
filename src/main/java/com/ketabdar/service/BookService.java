package com.ketabdar.service;


import com.ketabdar.entity.Book;
import com.ketabdar.repository.BookRepository;

public class BookService {


    public void saveBook(Book book) {
        BookRepository.save(book);
    }
}
