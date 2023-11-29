package com.tutorial.implementation;

import com.tutorial.entity.StudentEntity;
import com.tutorial.repository.StudentRepository;
import com.tutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.service
 * Created_on - 28 November-2023
 * Created_at - 22 : 08
 */

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentEntity addStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @Override
    public String deleteStudent(Integer id) {
        try {
            studentRepository.deleteById(id);
            return "Deleted";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }
}
