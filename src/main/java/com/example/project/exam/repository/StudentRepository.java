package com.example.project.exam.repository;

import com.example.project.exam.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
