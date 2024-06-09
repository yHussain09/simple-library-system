package com.example.simplelibrarysystem.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nonnull
    @Column(length = 13, nullable = false, unique = true)
    private String isbn;

    @Nonnull
    @Column(length = 50, nullable = false)
    private String title;

    @Nonnull
    @Column(length = 50, nullable = false)
    private String author;

    @Nonnull
    @Column(name = "book_count", nullable = false)
    private Integer count;

    public BookEntity() {}

    public BookEntity(String isbn, String title, String author, Integer count) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.count = count;
    }

    public BookEntity(Long id, @Nonnull String isbn, @Nonnull String title, @Nonnull String author, @Nonnull Integer count) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
