package com.ketabdar;


import com.ketabdar.service.BookService;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui extends JFrame {

    private JTextField bookNameField;
    private JTextField yearField;
    private JTextField authorIdField;
    private JButton addButton;

    public Gui() {
        setTitle("Book and Author Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JButton bookOptionsButton = new JButton("Book Options");
        JButton authorOptionsButton = new JButton("Author Options");

        mainPanel.add(new JLabel());
        mainPanel.add(bookOptionsButton);
        mainPanel.add(new JLabel());
        mainPanel.add(authorOptionsButton);

        add(mainPanel);

        bookOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the book registration form
                showBookRegistrationForm();
            }
        });

        authorOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Placeholder for author options, you can add your code here
                JOptionPane.showMessageDialog(null, "Author Options Clicked");
            }
        });
    }

    private void showBookRegistrationForm() {
        JPanel bookPanel = new JPanel();
        bookPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel bookNameLabel = new JLabel("Book Name:");
        bookNameField = new JTextField();
        JLabel yearLabel = new JLabel("Year of Publication:");
        yearField = new JTextField();
        JLabel authorIdLabel = new JLabel("Author ID:");
        authorIdField = new JTextField();
        addButton = new JButton("Add Book");

        bookPanel.add(bookNameLabel);
        bookPanel.add(bookNameField);
        bookPanel.add(yearLabel);
        bookPanel.add(yearField);
        bookPanel.add(authorIdLabel);
        bookPanel.add(authorIdField);
        bookPanel.add(new JLabel());
        bookPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = bookNameField.getText();
                int year = Integer.parseInt(yearField.getText());
                int authorId = Integer.parseInt(authorIdField.getText());

                // Call the BookService to add the book
                BookService bookService = new BookService();
                bookService.addBook(bookName, year, authorId);

                // Clear the input fields
                bookNameField.setText("");
                yearField.setText("");
                authorIdField.setText("");
            }
        });

        getContentPane().removeAll();
        getContentPane().add(bookPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }
}
