package com.demoproject.demo.Controller;
import com.demoproject.demo.Repo.wishlist_repository;
import com.demoproject.demo.wishlist;
import com.demoproject.demo.wishlist_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/wishlist")

public class wishlist_controller {
    @Autowired
    private wishlist_repository wishlistRepository;

    @GetMapping(path="/get")
    public List<wishlist> getall() {
        return wishlistRepository.findAll();
    }

    @GetMapping(path = "/get/{wishlistID}")
    public List<wishlist> getwishlist(@PathVariable int wishlistID){
        return wishlistRepository.findByWishlistID(wishlistID);
    }

    @DeleteMapping(path="/delete/{wishlistID}")
    public void delete_wishlist(@PathVariable int wishlistID){
        wishlistRepository.delete_wishlist(wishlistID);
    }


    @PostMapping(path="/add/{userID}/{wishlistID}/{wishlistName}")
    public void add_wishlist(@PathVariable long userID, @PathVariable int wishlistID, @PathVariable String wishlistName){
        wishlistRepository.insert_wishlist(userID, wishlistID, wishlistName);
    }
}
