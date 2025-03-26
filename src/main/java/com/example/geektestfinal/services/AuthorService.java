package com.example.geektestfinal.services;

import com.example.geektestfinal.models.Author;
import com.example.geektestfinal.models.Book;

import com.example.geektestfinal.repositories.AuthorRepository;
import com.example.geektestfinal.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


//    public List<Author> getAuthors() {
//        return authorRepository.findAll();
//    }
    @Autowired
    private BookRepository bookRepository;

    // Retrieve books by author name
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }


}
