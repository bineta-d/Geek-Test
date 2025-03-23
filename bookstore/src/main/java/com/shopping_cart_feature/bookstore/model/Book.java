package com.shopping_cart_feature.bookstore.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "books")
@Data
@Getter
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
