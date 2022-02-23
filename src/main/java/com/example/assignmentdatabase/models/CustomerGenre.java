package com.example.assignmentdatabase.models;

import java.util.ArrayList;

public class CustomerGenre {
    private String genre;


    public CustomerGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = String.valueOf(genre);
    }
}
