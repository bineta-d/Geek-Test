package com.geektest.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.geektest.bookstore.model.ShoppingCart;

public interface ShoppingCartRepository extends ListCrudRepository<ShoppingCart, Long> {
    //repository that takes the shopping cart object and the userID
    List<ShoppingCart> findByUserId(Long userId);
}
