package com.ketabdar.entity;

import java.util.Arrays;

public class Author {
    private String firstName;
    private String lastName;
    private int age;
    private Book[] listOfBooks;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Book[] getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(Book[] listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", listOfBooks=" + Arrays.toString(listOfBooks) +
                '}';
    }
}
