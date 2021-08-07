package com.carepay.assignment.service;

import javax.validation.Valid;

import com.carepay.assignment.domain.Post;
import com.carepay.assignment.domain.PostInfo;

import com.carepay.assignment.domain.CreatePostRequest;

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
    public Post createPost(@Valid CreatePostRequest createPostRequest) {
        return postRepository.save(new Post(createPostRequest.getTitle(), createPostRequest.getContent()));
    }

    @Override
    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
        //Transform/cast to post without details? .map(postDetails -> (PostInfo) postDetails);
    }

    @Override
    public Post getPostDetails(Long id) {
        return  postRepository.findById(id).get();
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
