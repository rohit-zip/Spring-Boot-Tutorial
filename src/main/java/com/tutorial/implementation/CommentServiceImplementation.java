package com.tutorial.implementation;

import com.tutorial.dto.ApiResponse;
import com.tutorial.dto.CommentRequest;
import com.tutorial.service.CommentService;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.implementation
 * Created_on - 21 December-2023
 * Created_at - 20 : 39
 */

@Service
public class CommentServiceImplementation implements CommentService {

    @Override
    public ApiResponse addComment(CommentRequest commentRequest, Long userId, Long postId) {
        return null;
    }

    @Override
    public ApiResponse getComment(Long commentId) {
        return null;
    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public ApiResponse updateComment(CommentRequest commentRequest, String postId, String commentId) {
        return null;
    }

    @Override
    public ApiResponse deleteComment(Long commentId) {
        return null;
    }
}
