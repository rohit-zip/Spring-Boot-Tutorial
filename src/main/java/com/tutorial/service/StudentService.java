package com.tutorial.service;

import com.tutorial.entity.Students;
import org.springframework.stereotype.Service;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.service
 * Created_on - 16 November-2023
 * Created_at - 20 : 45
 */

@Service // @Component // @Configuration
public class StudentService {

    public Students addStudent(Students students) {
        System.out.println(students.getFirstName());
        System.out.println(students.getLastName());
        return students;
    }
}
