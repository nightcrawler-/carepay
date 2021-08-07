package com.carepay.assignment.web;

import javax.validation.Valid;

import com.carepay.assignment.domain.CreatePostRequest;
import com.carepay.assignment.domain.PostDetails;
import com.carepay.assignment.domain.Comment;
import com.carepay.assignment.service.CommentService;
import com.carepay.assignment.service.CommentServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping(path = "/posts/{postId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    Page<Comment> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId, Pageable pageable) {
        return commentService.findByPostId(postId, pageable);
    }

    @GetMapping("{id}")
    Optional<Comment> findByIdAndPostId(@PathVariable(value = "postId") Long postId, @PathVariable(value = "id") Long id) {
        return commentService.findByIdAndPostId(id, postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Comment createComment(@PathVariable(value = "postId") Long postId, @Valid @RequestBody Comment comment) throws Exception {
        return commentService.createComment(postId, comment);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletePost(@PathVariable("id") final Long id) {
        commentService.deleteComment(id);
    }
}
