package com.example.gt_books.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "authors")  // Match the table name in your SQL
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Lob // For TEXT type
    @Column(nullable = false)
    private String biography;

    @Column(length = 50)
    private String publisher;


}

