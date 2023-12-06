package com.tutorial.repository;

import com.tutorial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.repository
 * Created_on - 06 December-2023
 * Created_at - 21 : 03
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
