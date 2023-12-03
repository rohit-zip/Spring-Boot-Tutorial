package com.tutorial.implementation;

import com.tutorial.entity.Student;
import com.tutorial.repository.StudentNameRepository;
import com.tutorial.service.StudentNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.implementation
 * Created_on - 03 December-2023
 * Created_at - 21 : 23
 */

@Service
public class Implementation implements StudentNameService {

    @Autowired
    private StudentNameRepository repository;

    @Override
    public Student addStudent(Student student) {
//        if (student.getFirstName().equals(null) || student.getName().equals("") || ObjectUtils.isEmpty(student.getFirstName())) {
//
//        }

        boolean empty = ObjectUtils.isEmpty(student);

        boolean isFirstNameEmpty = StringUtils.isEmpty(student.getFirstName());
        if (student.getFirstName().equals("")) {
            throw new RuntimeException("First Name cannot be Empty");
        }
        if (student.getLastName().equals("")) {
            throw new RuntimeException("Last Name cannot be Empty");
        }
        student.setName(student.getFirstName() + " " + student.getLastName());
        student.setIsActive(false);
        return repository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    public String markActive(Integer userId) {
        Student student = repository.findById(userId).get();
        if (!student.getIsActive()) {
            student.setIsActive(true);
        } else {
            return "Already Activated";
        }
        repository.save(student);
        return "Activated";
    }
}
