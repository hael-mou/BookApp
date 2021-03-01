package com.elmoudden.bookapp;

public class Book  {
    private String title,author,category;
    private int id;
    private int ratingScore;
    private int page;
    private int n_reviews;

    public Book(String title, String author, String category, int id, int ratingScore, int page, int n_reviews, int imageid) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.id = id;
        this.ratingScore = ratingScore;
        this.page = page;
        this.n_reviews = n_reviews;
        this.imageid = imageid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    private int imageid;


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
