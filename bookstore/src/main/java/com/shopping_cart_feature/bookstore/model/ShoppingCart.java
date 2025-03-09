package com.shopping_cart_feature.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
public class ShoppingCart {

    @Id
    private long cartId; //unique primary key
    
    private long userId;

    private long book; //a book by its ID

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