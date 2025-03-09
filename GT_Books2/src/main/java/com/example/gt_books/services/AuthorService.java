package com.example.gt_books.services;

import com.example.gt_books.models.Author;
import com.example.gt_books.models.Book;
import com.example.gt_books.repositories.AuthorRepository;
import com.example.gt_books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getBooksByAuthor(int authorId) {
        return authorRepository.findByAuthorId(authorId);
    }



}
