package com.geektext.bookcommentingandratingapi.repository;

import com.geektext.bookcommentingandratingapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    // Find comments by bookId
    List<Comment> findByBookId(int bookId);
}
