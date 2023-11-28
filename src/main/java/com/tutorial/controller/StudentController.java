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
        System.err.println("Entered in Controller createUser");
        String response = studentService.addUser(studentEntity);
        System.err.println("Returning data to user from the controller");
        return response;
    }

//    @GetMapping
//    public List<StudentEntity> getAll() {
//
//    }
//
//    //SPeL
//    @GetMapping("/{id}")
//    public Object findById(@PathVariable Integer id) {
//
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteById(@PathVariable Integer id) {
//
//    }
//
//    @PutMapping("/{id}")
//    public Object updateStudent(@RequestBody StudentEntity studentEntity, @PathVariable Integer id) {
//
//    }
}
