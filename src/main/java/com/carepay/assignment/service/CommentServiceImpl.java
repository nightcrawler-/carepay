package com.carepay.assignment.service;

import com.carepay.assignment.exceptions.ResourceNotFoundException;
import com.carepay.assignment.domain.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carepay.assignment.repository.CommentRepository;
import com.carepay.assignment.repository.PostRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Long postId, Comment comment) throws Exception {

        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new Exception("PostId " + postId + " not found"));

    }

    @Override
    public Page<Comment> findByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }

    @Override
    public Optional<Comment> findByIdAndPostId(Long id, Long postId) {
        Optional<Comment> result = commentRepository.findByIdAndPostId(id, postId);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return result;
    }

    @Override
    public void deleteComment(Long id) {
        try {
            commentRepository.findById(id).get();

        } catch (NoSuchElementException ex) {
            throw new ResourceNotFoundException();
        }
        commentRepository.deleteById(id);
    }
}
