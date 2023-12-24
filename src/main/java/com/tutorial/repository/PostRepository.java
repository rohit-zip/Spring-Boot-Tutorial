package com.tutorial.repository;

import com.tutorial.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.repository
 * Created_on - 15 December-2023
 * Created_at - 20 : 42
 */

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser_UserId(Long userId);
    List<Post> findByUser_Name(String name);
}
