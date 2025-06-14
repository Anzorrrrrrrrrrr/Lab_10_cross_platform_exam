package com.example.project.exam.controller;

import com.example.project.exam.model.Course;
import com.example.project.exam.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public String getCourses(Model model) {
        List<Course> courses = StreamSupport.stream(courseRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        model.addAttribute("courses", courses);
        return "courses";
    }
}
