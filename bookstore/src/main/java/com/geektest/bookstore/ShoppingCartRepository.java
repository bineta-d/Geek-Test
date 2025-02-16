package com.geektest.bookstore;

import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
    //repository that takes the shopping cart object and the userID
    
}
