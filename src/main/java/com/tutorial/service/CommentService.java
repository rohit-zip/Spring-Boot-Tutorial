package com.tutorial.service;

import com.tutorial.dto.ApiResponse;
import com.tutorial.dto.CommentRequest;
import com.tutorial.entity.Comments;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.service
 * Created_on - 21 December-2023
 * Created_at - 20 : 20
 */

public interface CommentService {

    ApiResponse addComment(CommentRequest commentRequest, Long userId, Long postId);
    Comments getComment(Long commentId);
    List<Comments> getAllComments();
    ApiResponse updateComment(CommentRequest commentRequest, Long commentId);
    ApiResponse deleteComment(Long commentId);
}
