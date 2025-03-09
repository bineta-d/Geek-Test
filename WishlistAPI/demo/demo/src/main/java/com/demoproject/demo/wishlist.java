package com.demoproject.demo;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "wishlist")

public class wishlist {
    @Id

    @Column(name = "wishlistID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wishlistID;

    @Column(name = "userID")
    private long userID;

    @Column(name = "wishlistName")
    private String wishlistName;
}
