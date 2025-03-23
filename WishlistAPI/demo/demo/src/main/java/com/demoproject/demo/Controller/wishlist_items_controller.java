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



    //GET MAPPINGS//
    @GetMapping(path="/get/wishlistid/{wishlistID}")
    public List<wishlist_items> get_wishlist_items(@PathVariable int wishlistID){
        return wishlist_items_repository.findByWishlistID(wishlistID);
    }

    @GetMapping(path="/get/itemid/{wishlistItemID}")
    public List<wishlist_items> get_item_id(@PathVariable long wishlistItemID){
        return wishlist_items_repository.findByWishlistItemID(wishlistItemID);
    }

    @GetMapping(path="/get/bookid/{bookID}")
    public List<wishlist_items> get_book_id(@PathVariable long bookID){
        return wishlist_items_repository.findByBookID(bookID);
    }
    //////////////////////////////////////////////////////////////

    @DeleteMapping(path="/delete/{wishlistID}/{bookID}")
    public void delete_by_wishlist_id_and_book_id(@PathVariable int wishlistID, @PathVariable long bookID){
        wishlist_items_repository.deleteByWishlistIdAndBookID(wishlistID, bookID);
    }

    @PostMapping(path="/add/{wishlistID}/{wishlistItemID}/{bookID}")
    public void add_by_wishlist_id_and_wishlist_item_id_and_book_id(@PathVariable int wishlistID, @PathVariable long wishlistItemID, @PathVariable long bookID){
        wishlist_items_repository.insertWishlist_items(wishlistID, wishlistItemID, bookID);
    }


}
