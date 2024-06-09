package com.example.simplelibrarysystem.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "borrow")
public class BorrowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", referencedColumnName = "id")
    private BorrowerEntity borrower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookEntity book;

    private Date borrowedDate;
    private Date returnedDate;
    private Boolean returned;

    public BorrowEntity() {
    }

    public BorrowEntity(Long id, BorrowerEntity borrower, BookEntity book, Date borrowedDate, Date returnedDate, Boolean returned) {
        this.id = id;
        this.borrower = borrower;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.returned = returned;
    }

    public BorrowEntity(BorrowerEntity borrower, BookEntity book, Date borrowedDate, Date returnedDate, Boolean returned) {
        this.borrower = borrower;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.returned = returned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BorrowerEntity getBorrower() {
        return borrower;
    }

    public void setBorrower(BorrowerEntity borrower) {
        this.borrower = borrower;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
