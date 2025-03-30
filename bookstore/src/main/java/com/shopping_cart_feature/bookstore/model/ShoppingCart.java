package com.shopping_cart_feature.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId; //unique primary key
    
    @Column(name = "user_id")
    private long userId;

    private long book; //a book by its ID

    public ShoppingCart() {}

    public ShoppingCart(long userId, long bookId) {
        this.userId = userId;
        this.book = bookId;
    }

    public long getBook() {
        return this.book;
    }

    public long getCartID() {
        return this.cartId;
    }

    public long getUserID() {
        return this.userId;
    }
}