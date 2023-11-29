package com.tutorial.service;

import com.tutorial.entity.StudentEntity;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.service
 * Created_on - 29 November-2023
 * Created_at - 20 : 22
 */

public interface StudentService {
    StudentEntity addStudent(StudentEntity studentEntity);
    String deleteStudent(Integer id);
}
