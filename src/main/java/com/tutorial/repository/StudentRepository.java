package com.tutorial.repository;

import com.tutorial.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.repository
 * Created_on - 17 November-2023
 * Created_at - 19 : 38
 */

//@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
}