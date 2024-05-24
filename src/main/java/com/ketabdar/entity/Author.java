package com.ketabdar.entity;

import java.util.Arrays;
import java.util.Date;

public class Author {
    private long id;
    private String name;
    private String biography;
    private Date birthdate;
    private String[] bookTitles;

    public Author() {
    }

    public Author(String name, String biography, Date birthdate) {
        this.name = name;
        this.biography = biography;
        this.birthdate = birthdate;
        this.bookTitles = new String[0];
    }

    public Author(long id, String name, String biography, Date birthdate) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.birthdate = birthdate;
        this.bookTitles = new String[0];
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String[] getBookTitles() {
        return bookTitles;
    }

    public void setBookTitles(String[] bookTitles) {
        this.bookTitles = bookTitles;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", biography='" + biography + '\'' +
                ", birthdate=" + birthdate +
                ", listOfBooks=" + Arrays.toString(bookTitles) +
                '}';
    }
}