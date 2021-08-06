package com.carepay.assignment.service;

import javax.validation.Valid;

import com.carepay.assignment.domain.CreatePostRequest;
import com.carepay.assignment.domain.PostDetails;
import com.carepay.assignment.domain.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carepay.assignment.repository.CommentRepository;
import com.carepay.assignment.repository.PostRepository;

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
            comment.setPostDetails(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new Exception("PostId " + postId + " not found"));
   
    }

    @Override
    public Page<Comment> findByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }

    @Override
    public Optional<Comment> findByIdAndPostId(Long id, Long postId) {
        return commentRepository.findByIdAndPostId(id, postId);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
