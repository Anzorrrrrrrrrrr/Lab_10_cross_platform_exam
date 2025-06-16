package com.example.project.exam.controller;

import com.example.project.exam.model.Course;
import com.example.project.exam.model.Enrollment;
import com.example.project.exam.model.Student;
import com.example.project.exam.repository.CourseRepository;
import com.example.project.exam.repository.EnrollmentRepository;
import com.example.project.exam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class EnrollmentController {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrollmentController(EnrollmentRepository enrollmentRepository,
                                StudentRepository studentRepository,
                                CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }


    @GetMapping("/enrollments")
    public String getEnrollments(Model model) {
        List<Enrollment> enrollments = StreamSupport.stream(enrollmentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        model.addAttribute("enrollments", enrollments);
        return "enrollments";
    }


    @GetMapping("/enrollments/create")
    public String showEnrollmentForm(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("courses", courseRepository.findAll());
        return "createEnrollment";
    }


    @PostMapping("/enrollments/create")
    public String createEnrollment(@RequestParam Long studentId,
                                   @RequestParam Long courseId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(studentOpt.get());
            enrollment.setCourse(courseOpt.get());
            enrollmentRepository.save(enrollment);
        }

        return "redirect:/enrollments";
    }
}
