package com.example.book_details.repo;

import com.example.book_details.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, String> {
    Book findByIsbn(String isbn);
    List<Book> findByAuthorId(int authorId);
}