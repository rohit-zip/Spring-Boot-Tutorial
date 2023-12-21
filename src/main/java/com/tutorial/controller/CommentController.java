package com.tutorial.controller;

import com.tutorial.dto.ApiResponse;
import com.tutorial.dto.CommentRequest;
import com.tutorial.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.controller
 * Created_on - 21 December-2023
 * Created_at - 20 : 36
 */

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${application.version}")
    private String applicationVersion;

    public ApiResponse addComment(@RequestBody CommentRequest commentRequest, @RequestParam(name = "userId") Long userId, @RequestParam(name = "postId") Long postId) {
        return commentService.addComment(commentRequest, userId, postId);
    }

    @GetMapping
    public String getData() {
        return applicationVersion;
    }
}
