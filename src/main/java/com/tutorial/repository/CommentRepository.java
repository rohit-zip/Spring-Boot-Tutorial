package com.tutorial.repository;

import com.tutorial.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.repository
 * Created_on - 24 December-2023
 * Created_at - 19 : 29
 */

public interface CommentRepository extends JpaRepository<Comments, Long> {
}
