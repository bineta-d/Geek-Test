package com.geektest.bookstore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Entity
//@Data
//@Table(name="shoppingcart")
public class ShoppingCart {
    @Id
    //@Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cart_id;

    //@Column(name = "user_id")
    private long user_id;

    //@Column(name = "book_id")
    private long book; //a book by its ID

    public HashMap<Long, Long> getCartBook() {
        HashMap<Long, Long> details = new HashMap<>();
        details.put(user_id, book);
        return details;
    }
}