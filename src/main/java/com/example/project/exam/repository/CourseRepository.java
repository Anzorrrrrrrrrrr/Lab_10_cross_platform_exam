package com.example.project.exam.repository;

import com.example.project.exam.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
