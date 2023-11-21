package com.tutorial.controller;

import com.tutorial.entity.Students;
import com.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.controller
 * Created_on - 17 November-2023
 * Created_at - 19 : 22
 */

@RestController
@RequestMapping("/students")
public class StudentsController {
    /**
     *
     * MVC -> Model View Controller
     * Model -> {
     *     1. It actually represents the application data and Business Logic
     *     2. It is responsible for managing the data and the validation or rules for processing it.
     * }
     *
     * View -> {
     *     1. It is Presentation or UI (User Interface) of the application
     *     2. Displays the data from the Model to the User and sends back the data from the user to Modal.
     * }
     *
     * Controller -> {
     *     1. Acts as an Broker or intermediary between the model and View
     *     2. Receives user input from the view and sends to the modal
     * }
     *
     * Frameworks -> Ruby on Rails (Ruby), Django (Python)
     */

    @Autowired
    private StudentRepository studentRepository;

//    @RequestMapping(method = RequestMethod.POST, path = "/create")
    @PostMapping("/create")
    public Students createUser(@RequestBody Students students) {
        Students savedStudent = studentRepository.save(students);
        return savedStudent;
    }

    //http://localhost:8080/create POST

    @GetMapping("/all-students")
    public List<Students> allStudents(@RequestBody Students students) {
        List<Students> allStudents = studentRepository.findAll();
        return allStudents;
    }
}
