package com.example.gt_books.repositories;
import java.util.List;

import com.example.gt_books.models.Author;
import com.example.gt_books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


//    Find Books By Author
    List<Book>findByAuthorId(int authorId);

}
