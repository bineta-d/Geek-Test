package com.demoproject.demo.Repo;
import com.demoproject.demo.wishlist;
import org.springframework.data.repository.CrudRepository;
import com.demoproject.demo.wishlist_items;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

public interface wishlist_items_repository extends ListCrudRepository<wishlist_items, Integer>{
    List<wishlist_items> findByWishlistID(Integer wishlistID);
}

