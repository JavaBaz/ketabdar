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


    public Author load(int authorId) {
        Author author = null;

        try (Connection connection = DBConnection.getConnection()) {
            String authorQuery = "SELECT * FROM author WHERE id = ?";
            PreparedStatement authorStatement = connection.prepareStatement(authorQuery);
            authorStatement.setInt(1, authorId);

            ResultSet authorResultSet = authorStatement.executeQuery();
            if (authorResultSet.next()) {
                int id = authorResultSet.getInt("id");
                String firstName = authorResultSet.getString("first_name");
                String lastName = authorResultSet.getString("last_name");
                int age = authorResultSet.getInt("age");

                author = new Author(id, firstName, lastName, age);

                String countQuery = "SELECT COUNT(*) AS total FROM book WHERE author = ?";
                PreparedStatement countStatement = connection.prepareStatement(countQuery);
                countStatement.setInt(1, authorId);

                ResultSet countResultSet = countStatement.executeQuery();
                if (countResultSet.next()) {
                    int numberOfBooks = countResultSet.getInt("total");
                    if(numberOfBooks == 0){
                        System.out.println("This author has no book");
                    }else {
                        String[] bookTitles = new String[numberOfBooks];

                        String titlesQuery = "SELECT title FROM book WHERE author = ?";
                        PreparedStatement titlesStatement = connection.prepareStatement(titlesQuery);
                        titlesStatement.setInt(1, authorId);

                        ResultSet titlesResultSet = titlesStatement.executeQuery();
                        int index = 0;
                        while (titlesResultSet.next()) {
                            String title = titlesResultSet.getString("title");
                            bookTitles[index] = title;
                            index++;
                        }

                        titlesResultSet.close();
                        titlesStatement.close();

                        author.setBookTitles(bookTitles);
                    }
                }

                countResultSet.close();
                countStatement.close();
            }

            authorResultSet.close();
            authorStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }


    public void lastRegistered() {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT MAX(id) AS last_id FROM author";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int lastId = resultSet.getInt("last_id");
                System.out.println(" with ID : " + lastId);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
