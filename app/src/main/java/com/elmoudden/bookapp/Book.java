package com.elmoudden.bookapp;

public class Book  {
    private String title,author;
    private int id,ratingScore , page , n_reviews;

    public Book(int id ,String title, String author, int ratingScore, int page, int n_reviews) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ratingScore = ratingScore;
        this.page = page;
        this.n_reviews = n_reviews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getN_reviews() {
        return n_reviews;
    }

    public void setN_reviews(int n_reviews) {
        this.n_reviews = n_reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
