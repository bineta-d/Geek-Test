package com.example.book_details.controller;

import com.example.book_details.models.Book;
import com.example.book_details.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @PostMapping(value = "/saveBook")
    public String saveBook(@RequestBody Book book) {
        bookRepo.save(book);
        return "Book Saved";
    }

    @GetMapping(value = "/book/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookRepo.findByIsbn(isbn);
    }

    @GetMapping(value = "/author/{authorId}/books")
    public List<Book> getBooksByAuthorId(@PathVariable int authorId) {
        return bookRepo.findByAuthorId(authorId);

    }

}
