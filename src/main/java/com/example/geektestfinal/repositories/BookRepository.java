package com.example.geektestfinal.repositories;
import com.example.geektestfinal.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByGenre(String genre);
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByRatingGreaterThanEqual(int rating);
    List<Book> findByRatingGreaterThanEqual(float rating);
    List<Book> findTop10ByOrderByCopiesSoldDesc();
    List <Book> findByPublisher(String publisher);
    List <Book> findByTitleContaining(String title);

    @Modifying
    @Query("UPDATE Book b SET b.price = b.price * :discountFactor WHERE b.publisher = :publisher")
    void applyDiscount(@Param("discountFactor") float discountFactor, @Param("publisher") String publisher);


}
