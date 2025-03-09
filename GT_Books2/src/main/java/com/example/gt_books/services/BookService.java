package com.example.gt_books.services;
import java.util.Optional;

import jakarta.transaction.Transactional;
import lombok.*;

import com.example.gt_books.models.Book;
import com.example.gt_books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
    // Fetch book-sorted by copies sold (descending)
    public List<Book> getTopSellingBooks() {
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
    }

    public List<Book> getBooksByRating(float rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }
    public List<Book> getBooksByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }


    @Transactional
    public void applyDiscount(String publisher, float discountPercent) {
        float discountFactor = 1 - (discountPercent / 100);
        bookRepository.applyDiscount(discountFactor, publisher);
    }

    // Fetch   book by its ID
    public Book getBookById(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
