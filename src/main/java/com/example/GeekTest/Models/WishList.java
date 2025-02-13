package com.example.GeekTest.Models;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "WishList")
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishListId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private String wishListName;

    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WishListItem> wishListItems;

    // Getters and setters
}

