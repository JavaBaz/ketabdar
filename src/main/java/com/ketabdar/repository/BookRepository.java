package com.ketabdar.repository;

import com.ketabdar.connection.DBConnection;
import com.ketabdar.entity.Book;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BookRepository {

    public static void save(Book book) {
        Connection connection = DBConnection.getConnection();


        try {
            String query = "INSERT INTO book (title, author, year_of_publication) " +
                           "VALUES ( ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getAuthorId());
            statement.setInt(3, book.getYearOfPublication());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
