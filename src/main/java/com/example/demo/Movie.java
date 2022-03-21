package com.example.demo;

public class Movie {
    public int id ;
    public String title;
    public int len;
    public double price;
    public String genre;


    public Movie(int id, String title, int len, double price, String genre) {
        this.id = id;
        this.title = title;
        this.len = len;
        this.price = price;
        this.genre = genre;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", len=" + len +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }
}
