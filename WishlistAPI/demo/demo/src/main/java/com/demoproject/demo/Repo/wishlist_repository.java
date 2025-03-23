package com.demoproject.demo.Repo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
//import org.springframework.data.repository.CrudRepository;
import com.demoproject.demo.wishlist;
import java.util.List;


public interface wishlist_repository extends ListCrudRepository<wishlist, Integer>{
    List<wishlist> findByWishlistID(Integer wishlistID);


    @Transactional
    @Modifying
    @Query("DELETE FROM wishlist w WHERE w.wishlistID = :wishlistID")
    void delete_wishlist(Integer wishlistID);


    @Transactional
    @Modifying
    @Query("INSERT INTO wishlist (userID, wishlistID, wishlistName) VALUES (:userID, :wishlistID, :wishlistName)")
    void insert_wishlist(Long userID, Integer wishlistID, String wishlistName);
}
