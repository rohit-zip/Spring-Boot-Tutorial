package com.tutorial.service;

import com.tutorial.entity.StudentEntity;
import com.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.service
 * Created_on - 28 November-2023
 * Created_at - 22 : 08
 */

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addUser(StudentEntity studentEntity) {
        System.err.println("Entered in StudentService addUser");
        StudentEntity save = studentRepository.save(studentEntity);
        System.err.println("Returning response from the StudentService");
        return "Student Saved successfully to the database";
    }
}
