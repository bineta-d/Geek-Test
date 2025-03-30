package com.geektext.bookcommentingandratingapi.controller;

import com.geektext.bookcommentingandratingapi.model.Comment;
import com.geektext.bookcommentingandratingapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    // New endpoint: Retrieve comments for a specific book
    @GetMapping("/{bookId}")
    public List<Comment> getCommentsByBookId(@PathVariable int bookId) {
        return commentRepository.findByBookId(bookId);
    }
}
