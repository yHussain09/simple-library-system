package com.example.simplelibrarysystem.dto;

public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer count;

    public BookDto() {
    }

    public BookDto(String title, String author, String isbn, Integer count) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.count = count;
    }

    public BookDto(Long id, String title, String author, String isbn, Integer count) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
