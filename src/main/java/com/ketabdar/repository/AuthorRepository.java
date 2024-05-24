package com.ketabdar.repository;

import com.ketabdar.connection.DBConnection;
import com.ketabdar.entity.Author;

import java.sql.*;
import java.util.Date;

public class AuthorRepository {
    private Connection connection;

    public AuthorRepository() {
        this.connection = DBConnection.getConnection();
    }

    public void save(Author author) {
        String sql = "INSERT INTO authors (name, biography, birthdate) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getBiography());
            preparedStatement.setDate(3, new java.sql.Date(author.getBirthdate().getTime()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Author load(String authorName) {
        String authorQuery = "SELECT * FROM authors WHERE name = ?";

        try (PreparedStatement authorStatement = connection.prepareStatement(authorQuery)) {
            authorStatement.setString(1, authorName);
            ResultSet authorResultSet = authorStatement.executeQuery();

            if (authorResultSet.next()) {
                long id = authorResultSet.getLong("author_id");
                String name = authorResultSet.getString("name");
                String biography = authorResultSet.getString("biography");
                Date birthdate = authorResultSet.getDate("birthdate");

                Author author = new Author(id, name, biography, birthdate);

                String countQuery = "SELECT COUNT(*) AS total FROM books WHERE author_id = ?";
                try (PreparedStatement countStatement = connection.prepareStatement(countQuery)) {
                    countStatement.setLong(1, id);
                    ResultSet countResultSet = countStatement.executeQuery();
                    if (countResultSet.next()) {
                        int numberOfBooks = countResultSet.getInt("total");
                        if (numberOfBooks == 0) {
                            System.out.println("This author has no books");
                        } else {
                            String[] bookTitles = new String[numberOfBooks];
                            String titlesQuery = "SELECT title FROM books WHERE author_id = ?";
                            try (PreparedStatement titlesStatement = connection.prepareStatement(titlesQuery)) {
                                titlesStatement.setLong(1, id);
                                ResultSet titlesResultSet = titlesStatement.executeQuery();
                                int index = 0;
                                while (titlesResultSet.next()) {
                                    String title = titlesResultSet.getString("title");
                                    bookTitles[index] = title;
                                    index++;
                                }
                                author.setBookTitles(bookTitles);
                            }
                        }
                    }
                }
                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void lastRegistered() {
        String query = "SELECT MAX(author_id) AS last_id FROM authors";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int lastId = resultSet.getInt("last_id");
                System.out.println(" with ID : " + lastId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}