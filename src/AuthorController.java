package com.example.book_details.controller;

import com.example.book_details.models.Author;
import com.example.book_details.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepo authorRepo;

    @PostMapping(value = "/saveAuthor")
    public String saveUser(@RequestBody Author author) {
        authorRepo.save(author);
        return "Author Saved";
    }

}
