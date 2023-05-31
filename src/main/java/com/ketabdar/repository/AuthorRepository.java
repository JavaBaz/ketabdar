package com.ketabdar.repository;

import com.ketabdar.connection.DBConnection;
import com.ketabdar.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorRepository {


    public void save(Author author) {

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO author (first_name, last_name, age)" +
                                                                                                               " VALUES (?,?,?);");
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setInt   (3, author.getAge());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
