package com.example.geektestfinal.controllers;
import com.example.geektestfinal.models.Book;
import com.example.geektestfinal.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gt_books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/gt_books")
    public String defaultMapping() {
        return "Welcome to GT Books! Use the /all, /genre/{genre}, or /rating/{rating} endpoints to get data.";
    }

    //  format example: http://localhost:8082/gt_books/books/2
    @GetMapping("/books/{book_id}")
    public Book getBookById(@PathVariable Long book_id) {  // bookId should be Long
        return bookService.getBookById(book_id);
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    //  format example: http://localhost:8082/gt_books/genres/Horror
    @GetMapping(path ="/genres/{genre}")
    public @ResponseBody List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    //  format example: http://localhost:8082/gt_books/rating/3
    @GetMapping(path="/rating/{rating}")
    public @ResponseBody List <Book> getBooksByRating(@PathVariable float rating){
    return bookService.getBooksByRating(rating);
    }

    //  format example: http://localhost:8082/gt_books/top_sellers
    @GetMapping(path="/top_sellers")
    public @ResponseBody List <Book> getTopSellingBooks(){
        return bookService.getTopSellingBooks();
    }

    //  format example: http://localhost:8082/gt_books/publishers/Bloomsbury
    @GetMapping(path="/publishers/{publisher}")
    public @ResponseBody List<Book> getBooksByPublisher(@PathVariable String publisher){
        return bookService.getBooksByPublisher(publisher);
    }

    //  format example: http://localhost:8082/gt_books/author/Tolkien
    @PutMapping("/discount")
    public ResponseEntity<String> applyDiscount( @RequestParam float discountPercent, @RequestParam String publisher) {
        bookService.applyDiscount(publisher, discountPercent);
        return ResponseEntity.ok("Discount applied successfully to books by publisher: " + publisher);
    }

    //  format example: http://localhost:8082/gt_books/author/Tolkien
    @GetMapping(path="/authors/{author}")
    public @ResponseBody List<Book> getBooksByAuthor(@PathVariable String author){
        return bookService.getBooksByAuthor(author);
    }
//  format example: http://localhost:8082/gt_books/books/by-title?title=Harry
    @GetMapping(path="/books/by-title")
    public @ResponseBody List<Book> getBooksByTitleContaining(@RequestParam String title){
        return bookService.getBooksByTitleContaining(title);
    }



}
