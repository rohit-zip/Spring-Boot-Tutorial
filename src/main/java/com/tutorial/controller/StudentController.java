package com.tutorial.controller;

import com.tutorial.entity.Students;
import com.tutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.controller
 * Created_on - 16 November-2023
 * Created_at - 20 : 42
 */

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //CRUD -> Create, Read, Update and Delete

    public Students createStudent(Students students) {
        Students data = studentService.addStudent(students);
        return data;
    }
}
