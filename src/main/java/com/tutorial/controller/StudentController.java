package com.tutorial.controller;

import com.tutorial.entity.StudentEntity;
import com.tutorial.repository.StudentRepository;
import org.hibernate.type.IntegerType;
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
    private StudentRepository studentRepository;

    @PostMapping
    public String createUser(@RequestBody StudentEntity studentEntity) {
//        StudentEntity savedStudent = studentRepository.save(studentEntity);
        studentRepository.save(studentEntity);
        return "Student Saved to the Database Successfully";
    }

    @GetMapping
    public List<StudentEntity> getAll() {
        List<StudentEntity> allStudents = studentRepository.findAll();
        return allStudents;
    }

    //SPeL
    @GetMapping("/{id}")
    public Object findById(@PathVariable Integer id) {
        Optional<StudentEntity> byId = studentRepository.findById(id);
        if (byId.isPresent()) {
            StudentEntity studentEntity = byId.get();
            return studentEntity;
        } else {
            return "Student not found for Id : " + id;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Student Data deleted from Database Successfully";
    }

    @PutMapping("/{id}")
    public Object updateStudent(@RequestBody StudentEntity studentEntity, @PathVariable Integer id) {
        Optional<StudentEntity> byId = studentRepository.findById(id);
        if (byId.isPresent()) {
            studentEntity.setStudentId(id);
            StudentEntity updatedStudent = studentRepository.save(studentEntity);
            return updatedStudent;
        } else {
            return "Student Data Not Found";
        }
    }
}
