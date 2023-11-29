package com.tutorial.controller;

import com.tutorial.entity.StudentEntity;
import com.tutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.controller
 * Created_on - 27 November-2023
 * Created_at - 23 : 35
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentEntity createUser(@RequestBody StudentEntity studentEntity) {
        return studentService.addStudent(studentEntity);
    }

//    @DeleteMapping("/{id}")
//    public String deleteById(@PathVariable Integer id) {
//
//    }
}
