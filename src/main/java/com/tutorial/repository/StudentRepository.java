package com.tutorial.repository;

import com.tutorial.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.repository
 * Created_on - 27 November-2023
 * Created_at - 23 : 36
 */

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
