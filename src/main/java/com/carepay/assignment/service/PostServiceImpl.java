package com.carepay.assignment.service;

import javax.validation.Valid;

import com.carepay.assignment.domain.CreatePostRequest;
import com.carepay.assignment.domain.PostDetails;
import com.carepay.assignment.domain.PostInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carepay.assignment.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    
    @Override
    public PostDetails createPost(@Valid CreatePostRequest createPostRequest) {
        throw new IllegalArgumentException("Not implemented"); // TODO: Implement
    }

    @Override
    public Page<PostInfo> getPosts(Pageable pageable) {
        throw new IllegalArgumentException("Not implemented"); // TODO: Implement

        //return (Page<PostInfo>)postRepository.findAll(pageable);
    }

    @Override
    public PostDetails getPostDetails(Long id) {
        return (PostDetails)postRepository.findById(id).get();
    }

    @Override
    public void deletePost(Long id) {
        throw new IllegalArgumentException("Not implemented"); // TODO: Implement
    }
}
