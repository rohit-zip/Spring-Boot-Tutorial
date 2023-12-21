package com.tutorial.controller;

import com.tutorial.dto.PostRequest;
import com.tutorial.dto.PostResponse;
import com.tutorial.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.controller
 * Created_on - 15 December-2023
 * Created_at - 20 : 29
 */

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/{userId}")
    public PostResponse addPost(@RequestBody @Valid PostRequest postRequest, @PathVariable Long userId){
        return postService.addPost(postRequest, userId);
    }
}
