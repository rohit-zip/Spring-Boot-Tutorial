package com.tutorial.repository;

import com.tutorial.entity.Student;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.repository
 * Created_on - 03 December-2023
 * Created_at - 21 : 22
 */

public interface StudentNameRepository extends JpaRepository<Student, Integer> {
}
