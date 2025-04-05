package com.geektext.bookcommentingandratingapi.controller;

import com.geektext.bookcommentingandratingapi.model.Rating;
import com.geektext.bookcommentingandratingapi.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @GetMapping("/{bookId}")
    public List<Rating> getRatingsByBookId(@PathVariable int bookId) {
        return ratingRepository.findByBookId(bookId);
    }

    // ✅ New endpoint: Get the average rating for a book, rounded to 2 decimal places
    @GetMapping("/average/{bookId}")
    public double getAverageRating(@PathVariable int bookId) {
        Double average = ratingRepository.findAverageRatingByBookId(bookId);
        return BigDecimal.valueOf(average).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}

