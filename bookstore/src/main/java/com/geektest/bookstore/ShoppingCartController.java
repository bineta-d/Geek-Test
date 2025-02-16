package com.geektest.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@RestController
@RequestMapping(path="/shoppingcart")
public class ShoppingCartController {
    @Autowired

    private ShoppingCartRepository shoppingCartRepository;

    @GetMapping(path="/get") //takes the user's requests and sends them to the model for handling
    public @ResponseBody Iterable<ShoppingCart> getShoppingCarts() {
        return shoppingCartRepository.findAll();
    }
}
