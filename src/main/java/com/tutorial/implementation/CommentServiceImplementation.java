package com.tutorial.implementation;

import com.tutorial.dto.ApiResponse;
import com.tutorial.dto.CommentRequest;
import com.tutorial.entity.Comments;
import com.tutorial.entity.Post;
import com.tutorial.entity.User;
import com.tutorial.exception.UserNotFoundException;
import com.tutorial.repository.CommentRepository;
import com.tutorial.repository.PostRepository;
import com.tutorial.repository.UserRepository;
import com.tutorial.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
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
@RequiredArgsConstructor
public class CommentServiceImplementation implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

//    public CommentServiceImplementation(CommentRepository commentRepository) {
//        this.commentRepository = commentRepository;
//    }

    @Override
    public ApiResponse addComment(CommentRequest commentRequest, Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User", "User Id", userId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new UserNotFoundException("Post", "Post Id", postId));

        //Convert CommentRequest to Comments
        Comments comments = Comments
                .builder()
                .comment(commentRequest.getComment())
                .dateCommented(new Date())
                .user(user)
                .post(post)
                .build();
        commentRepository.save(comments);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Comment Added");
        return apiResponse;
    }

    @Override
    public Comments getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(()-> new UserNotFoundException("Comment", "Comment Id", commentId));
    }

    @Override
    public List<Comments> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public ApiResponse updateComment(CommentRequest commentRequest, Long commentId) {
        Comments comments = commentRepository.findById(commentId)
                .orElseThrow(() -> new UserNotFoundException("Comment", "Comment Id", commentId));
        comments.setComment(commentRequest.getComment());
        commentRepository.save(comments);
        return new ApiResponse("Comment Edited");
    }

    @Override
    public ApiResponse deleteComment(Long commentId) {
        Comments comments = commentRepository.findById(commentId)
                .orElseThrow(() -> new UserNotFoundException("Comment", "Comment Id", commentId));
        commentRepository.delete(comments);
        return new ApiResponse("Comment Deleted");
    }
}
