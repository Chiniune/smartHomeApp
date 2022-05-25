package com.rajendra.onlinedailygroceries.model;


public class Comment {

    String username;
    int imageUrl;
    float rating;
    String date;
    private String content;

    public Comment(String username, int imageUrl, float rating, String date, String content) {
        this.username = username;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.date = date;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }


}
