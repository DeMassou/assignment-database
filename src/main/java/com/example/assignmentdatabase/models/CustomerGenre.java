package com.example.assignmentdatabase.models;

public class CustomerGenre {
    private String customerId;
    private String genre;
    private String tracks;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public CustomerGenre(String customerId, String genre, String tracks, int amount) {
        this.customerId = customerId;
        this.genre = genre;
        this.tracks = tracks;
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }
}
