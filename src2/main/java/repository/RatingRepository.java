package com.geektext.bookcommentingandratingapi.repository;

import com.geektext.bookcommentingandratingapi.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    // Find ratings by bookId
    List<Rating> findByBookId(int bookId);

    // ✅ New method: Calculate the average rating for a book
    @Query("SELECT COALESCE(AVG(r.rating), 0) FROM Rating r WHERE r.bookId = :bookId")
    Double findAverageRatingByBookId(@Param("bookId") int bookId);
}

