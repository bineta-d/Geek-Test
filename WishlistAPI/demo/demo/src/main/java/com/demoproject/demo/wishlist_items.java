package com.demoproject.demo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "wishlist_items")

public class wishlist_items {
    @Id

    @Column(name = "wishlistItemID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long wishlistItemID;

    @Column(name = "wishlistID")
    private int wishlistID;

    @Column(name = "bookID")
    private long bookID;
}
