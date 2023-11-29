package com.tutorial.controller;

import com.tutorial.entity.StudentEntity;
import com.tutorial.repository.StudentRepository;
import com.tutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String createUser(@RequestBody StudentEntity studentEntity) {
        String response = studentService.addUser(studentEntity);
        return response;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        return studentService.delete(studentService.delete(id.toString()));
    }
}
