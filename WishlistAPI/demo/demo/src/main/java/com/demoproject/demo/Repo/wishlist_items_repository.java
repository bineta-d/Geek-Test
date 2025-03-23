package com.demoproject.demo.Repo;
import com.demoproject.demo.wishlist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.demoproject.demo.wishlist_items;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

public interface wishlist_items_repository extends ListCrudRepository<wishlist_items, Integer>{
    List<wishlist_items> findByWishlistID(Integer wishlistID);
    List<wishlist_items> findByWishlistItemID(Long wishlistItemID);
    List<wishlist_items> findByBookID(Long bookID);

    @Transactional
    @Modifying
    @Query("DELETE FROM wishlist_items w WHERE w.wishlistID = :wishlistID AND w.bookID = :bookID")
    void deleteByWishlistIdAndBookID(Integer wishlistID, Long bookID);


    @Transactional
    @Modifying
    @Query("INSERT INTO wishlist_items (wishlistID, bookID, wishlistItemID) VALUES (:wishlistID, :bookID, :wishlistItemID)")
    void insertWishlist_items(Integer wishlistID, Long wishlistItemID, Long bookID);
}

