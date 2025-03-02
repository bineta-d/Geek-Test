package com.demoproject.demo.Repo;
import org.springframework.data.repository.ListCrudRepository;
//import org.springframework.data.repository.CrudRepository;
import com.demoproject.demo.wishlist;
import java.util.List;


public interface wishlist_repository extends ListCrudRepository<wishlist, Integer>{
    List<wishlist> findByWishlistID(Integer wishlistID);
}
