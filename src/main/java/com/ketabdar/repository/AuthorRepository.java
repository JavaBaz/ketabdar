package com.ketabdar.repository;

import com.ketabdar.connection.DBConnection;
import com.ketabdar.entity.Author;

import java.sql.*;

public class AuthorRepository {


    public void save(Author author) {

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO author (first_name, last_name, age)" +
                    " VALUES (?,?,?);");
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setInt(3, author.getAge());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Author load(int id) {
        Author author = null;

        try {
            String query = "SELECT * FROM author WHERE id = ?";
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int authorId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");

                author = new Author(authorId, firstName, lastName, age);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }



}
