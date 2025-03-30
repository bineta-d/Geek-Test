package com.example.geektestfinal.controllers;

import com.example.geektestfinal.models.Author;
import com.example.geektestfinal.models.Book;
import com.example.geektestfinal.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/books/by-author")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return authorService.getBooksByAuthor(author);
    }



//
//    @GetMapping("/authors")
//    public List<Author> getAuthor() {
//        return authorService.getAuthors();
//    }

}
