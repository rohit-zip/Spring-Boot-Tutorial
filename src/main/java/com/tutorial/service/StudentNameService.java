package com.tutorial.service;

import com.tutorial.entity.Student;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.service
 * Created_on - 03 December-2023
 * Created_at - 21 : 21
 */

public interface StudentNameService {

    Student addStudent(Student student);
    List<Student> getAll();
}
