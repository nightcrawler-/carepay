package com.carepay.assignment.service;

import javax.validation.Valid;

import com.carepay.assignment.domain.CreatePostRequest;
import com.carepay.assignment.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Post createPost(@Valid CreatePostRequest createPostRequest);

    Page<Post> getPosts(final Pageable pageable);

    Post getPostDetails(Long id);

    void deletePost(Long id);
}
