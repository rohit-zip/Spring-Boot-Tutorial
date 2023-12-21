package com.tutorial.service;

import com.tutorial.dto.PostRequest;
import com.tutorial.dto.PostResponse;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.service
 * Created_on - 15 December-2023
 * Created_at - 20 : 30
 */
public interface PostService {

    PostResponse addPost(PostRequest postRequest, Long userId);
    PostResponse getPost(Long postId);
    List<PostResponse> getPosts();
    PostResponse updatePost(PostRequest postRequest, Long postId, Long userId);
    void deletePost(Long postId);
    List<PostResponse> getPostByUser(Long userId);
}
