package com.example.gt_books.controllers;
import com.example.gt_books.models.Book;
import com.example.gt_books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gt_books/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String defaultMapping() {
        return "Welcome to GT Books! Use the /all, /genre/{genre}, or /rating/{rating} endpoints to get data.";
    }
    @GetMapping("/book/{book_id}")
    public Book getBookById(@PathVariable Long book_id) {  // bookId should be Long
        return bookService.getBookById(book_id);
    }

    @GetMapping("/all")
    public @ResponseBody List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path ="/genre/{genre}")
    public @ResponseBody List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }
    @GetMapping(path="/rating/{rating}")
    public @ResponseBody List <Book> getBooksByRating(@PathVariable float rating){
    return bookService.getBooksByRating(rating);
    }
    @GetMapping(path="/top_sellers")
    public @ResponseBody List <Book> getTopSellingBooks(){
        return bookService.getTopSellingBooks();
    }
    @GetMapping(path="/publishers/{publisher}")
    public @ResponseBody List<Book> getBooksByPublisher(@PathVariable String publisher){
        return bookService.getBooksByPublisher(publisher);
    }
//
    @PutMapping("/discount")
    public ResponseEntity<String> applyDiscount( @RequestParam float discountPercent, @RequestParam String publisher) {
        bookService.applyDiscount(publisher, discountPercent);
        return ResponseEntity.ok("Discount applied successfully to books by publisher: " + publisher);
    }

}
