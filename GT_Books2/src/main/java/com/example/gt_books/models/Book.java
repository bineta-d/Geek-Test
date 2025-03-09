package com.example.gt_books.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, length = 100)
    private String genre;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Float rating;

    @Column(name="copies_sold", nullable = false)
    private Integer copiesSold;


}
