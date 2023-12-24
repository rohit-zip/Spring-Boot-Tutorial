package com.tutorial.implementation;

import com.tutorial.dto.PostRequest;
import com.tutorial.dto.PostResponse;
import com.tutorial.entity.Post;
import com.tutorial.entity.User;
import com.tutorial.exception.UserNotFoundException;
import com.tutorial.repository.PostRepository;
import com.tutorial.repository.UserRepository;
import com.tutorial.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.implementation
 * Created_on - 15 December-2023
 * Created_at - 20 : 34
 */

@Service
public class PostImplementation implements PostService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostResponse addPost(PostRequest postRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User", "User Id", userId));
        Post post = Post
                .builder()
                .title(postRequest.getTitle())
                .description(postRequest.getDescription())
                .dateCreated(new Date())
                .user(user)
                .build();
        Post savedPost = postRepository.save(post);

//        PostResponse postResponse = new PostResponse();
//        postResponse.setPostId(savedPost.getPostId());
//        postResponse.setTitle(savedPost.getTitle());
//        postResponse.setDescription(savedPost.getDescription());
//        postResponse.setCreatedOn(savedPost.getDateCreated());
//        postResponse.setUserId(savedPost.getUser().getUserId());
//        return postResponse;

        return PostResponse
                .builder()
                .postId(savedPost.getPostId())
                .title(savedPost.getTitle())
                .description(savedPost.getDescription())
                .createdOn(savedPost.getDateCreated())
                .userId(savedPost.getUser().getUserId())
                .build();
    }

    @Override
    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new UserNotFoundException("Post", "Post Id", postId));

        // Convert to Post response
        return PostResponse
                .builder()
                .userId(post.getUser().getUserId())
                .createdOn(post.getDateCreated())
                .description(post.getDescription())
                .title(post.getTitle())
                .build();
    }

    @Override
    public List<PostResponse> getPosts() {
        List<Post> postList = postRepository.findAll();

        List<PostResponse> response = new ArrayList<>();
        for (Post post : postList) {
            PostResponse postResponse = PostResponse
                    .builder()
                    .userId(post.getUser().getUserId())
                    .createdOn(post.getDateCreated())
                    .description(post.getDescription())
                    .title(post.getTitle())
                    .build();
            response.add(postResponse);
        }
        return response;
    }

    @Override
    public PostResponse updatePost(PostRequest postRequest, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new UserNotFoundException("Post", "Post Id", postId));
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        Post savedPost = postRepository.save(post);
        return PostResponse
                .builder()
                .userId(savedPost.getUser().getUserId())
                .createdOn(savedPost.getDateCreated())
                .description(savedPost.getDescription())
                .title(savedPost.getTitle())
                .build();
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new UserNotFoundException("Post", "Post Id", postId));
        postRepository.delete(post);
    }

    @Override
    public List<PostResponse> getPostByUser(Long userId) {
        List<Post> postList = postRepository.findByUser_UserId(userId);
        List<PostResponse> response = new ArrayList<>();
        for (Post post : postList) {
            PostResponse postResponse = PostResponse
                    .builder()
                    .userId(post.getUser().getUserId())
                    .createdOn(post.getDateCreated())
                    .description(post.getDescription())
                    .title(post.getTitle())
                    .build();
            response.add(postResponse);
        }
        return response;
    }
}
