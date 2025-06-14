package com.example.project.exam.controller;

import com.example.project.exam.model.Student; // Import your Student entity
import com.example.project.exam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Use @Controller for returning views
import org.springframework.ui.Model; // Import Model
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController; // Remove or change to @Controller

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller // Changed from @RestController to @Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String getStudents(Model model) { // Add Model parameter
        // Read all students from the database
        List<Student> students = StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        // Add the list of students to the Model, so it can be accessed in the JTE template
        model.addAttribute("students", students);

        // Return the name of the JTE template file (e.g., "students.jte")
        // Spring will automatically look for src/main/jte/students.jte
        return "students";
    }
}