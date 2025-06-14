package com.example.project.exam.controller;

import com.example.project.exam.model.Teacher;
import com.example.project.exam.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class TeacherController {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        List<Teacher> teachers = StreamSupport.stream(teacherRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        model.addAttribute("teachers", teachers);
        return "teachers";
    }
}
