package com.demoproject.demo.Controller;
import com.demoproject.demo.Repo.wishlist_items_repository;
import com.demoproject.demo.Repo.wishlist_repository;
import com.demoproject.demo.wishlist;
import com.demoproject.demo.wishlist_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path="/wishlist/books")

public class wishlist_items_controller {
    @Autowired
    private wishlist_items_repository wishlist_items_repository;

    @Autowired
    private wishlist_repository wishlist_repository;

    @GetMapping(path="/get/{wishlistID}")
    public List<wishlist_items> get_wishlist_items(@PathVariable int wishlistID){
        return wishlist_items_repository.findByWishlistID(wishlistID);
    }
}
