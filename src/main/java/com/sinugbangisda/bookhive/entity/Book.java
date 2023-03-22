package com.sinugbangisda.bookhive.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 25, nullable = false)
    private String name;
    @Column(name = "author", length = 15, nullable = false)
    private String author;
    @Column(name = "genre", length = 10, nullable = false)
    private String genre;
    @Column(name = "price", length = 10)
    private Integer price;

    public Book(Integer id, String name, String author, String genre, Integer price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}
