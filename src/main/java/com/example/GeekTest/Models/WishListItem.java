package com.example.GeekTest.Models;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "WishListItem")
public class WishListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishlistItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wishlistId", nullable = false)
    private WishList wishlist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", nullable = false)
    private Book book;

    // Getters and setters
}

