package com.example.project.exam.controller;

import com.example.project.exam.model.Enrollment;
import com.example.project.exam.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class EnrollmentController {

    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentController(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @GetMapping("/enrollments")
    public String getEnrollments(Model model) {
        List<Enrollment> enrollments = StreamSupport.stream(enrollmentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        model.addAttribute("enrollments", enrollments);
        return "enrollments";
    }
}
