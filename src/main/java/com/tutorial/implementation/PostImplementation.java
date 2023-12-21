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
        return null;
    }

    @Override
    public List<PostResponse> getPosts() {
        return null;
    }

    @Override
    public PostResponse updatePost(PostRequest postRequest, Long postId, Long userId) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public List<PostResponse> getPostByUser(Long userId) {
        return null;
    }
}
