package com.carepay.assignment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.carepay.assignment.domain.Comment;

import java.util.Optional;

public interface CommentService {
    Page<Comment> findByPostId(Long postId, Pageable pageable);

    Optional<Comment> findByIdAndPostId(Long id, Long postId);

    Comment createComment(Long postId, Comment comment) throws Exception;

    void deleteComment(Long id);
}
