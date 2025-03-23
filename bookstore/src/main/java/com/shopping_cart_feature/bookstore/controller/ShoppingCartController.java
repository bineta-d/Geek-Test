package com.shopping_cart_feature.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shopping_cart_feature.bookstore.model.Book;
import com.shopping_cart_feature.bookstore.model.ShoppingCart;
import com.shopping_cart_feature.bookstore.repository.BookRepository;
import com.shopping_cart_feature.bookstore.repository.ShoppingCartRepository;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/shoppingcart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path="/get") //debugging
    public List<ShoppingCart> getAll() {
        return shoppingCartRepository.findAll();
    }

    //-----------------------------------------------------------------------------
    @GetMapping(path="/get/{userID}") //get books from user's cart
    public List<Book> getShoppingCart(@PathVariable long userID) {

        List<ShoppingCart> cartItems = shoppingCartRepository.findByUserId(userID);

        List<Long> cartBookIds = (List<Long>) cartItems.stream()
                                                        .map(cart -> cart.getBook())
                                                        .toList();

        return bookRepository.findByBookIdIn(cartBookIds);

    }
    //----------------------------------------------------------------------

    @GetMapping(path="/subtotal/{userID}") //get cart subtotal
    public double getShoppingCartSubtotal(@PathVariable long userID) { //dependency injection
        List<ShoppingCart> cartItems = shoppingCartRepository.findByUserId(userID);

        List<Long> cartBookIds = (List<Long>) cartItems.stream()
                                                        .map(cart -> cart.getBook())
                                                        .toList();

        List<Book> cartBooks = bookRepository.findByBookIdIn(cartBookIds);

        double subtotal = 0.0;
        
        subtotal = cartBooks.stream()
                            .mapToDouble(book -> book.getPrice().doubleValue())
                            .sum();
        
        return subtotal;
    }

    // @PostMapping(path="/addToCart")
    // public void addToCard(@RequestBody ShoppingCart cartItem) {
    //     shoppingCartRepository.save(cartItem);
    // }

    @PostMapping(path="/addToCart/user={userId}&book={bookId}")
    public void addToCard(@PathVariable long userId, @PathVariable long bookId) {
        shoppingCartRepository.save(new ShoppingCart(userId, bookId));
    }
}