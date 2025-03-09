package com.example.gt_books.controllers;

import com.example.gt_books.models.Book;
import com.example.gt_books.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class AuthorController {

    private AuthorService authorService;

    @GetMapping("/author/{genre}")
    public List<Book> getBooksByAuthor(@PathVariable int authorId) {
        return authorService.getBooksByAuthor(authorId);
    }

}
