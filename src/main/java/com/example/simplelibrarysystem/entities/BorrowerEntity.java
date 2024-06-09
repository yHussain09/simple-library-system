package com.example.simplelibrarysystem.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "borrower")
public class BorrowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nonnull
    @Column(nullable = false)
    private String name;

    @Nonnull
    @Column(unique = true, nullable = false)
    private String email;

    public BorrowerEntity() {}

    public BorrowerEntity(Long id, @Nonnull String name, @Nonnull String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public BorrowerEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
