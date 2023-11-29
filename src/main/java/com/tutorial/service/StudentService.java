package com.tutorial.service;

import com.tutorial.entity.StudentEntity;
import com.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        StudentEntity save = studentRepository.save(studentEntity);
        return "Student Saved successfully to the database";
    }

    public List<StudentEntity> getAll() {
        return studentRepository.findAll();
    }

    public String delete(String id) {
        int idData;
        try {
            idData = Integer.parseInt(id);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        try {
            studentRepository.deleteById(idData);
            return "Deleted";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }
}
