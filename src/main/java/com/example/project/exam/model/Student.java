package com.example.project.exam.model;

import com.example.project.exam.model.Enrollment;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter // Додайте
@Setter // Додайте
@ToString(exclude = "enrollments") // Додайте і виключіть поле, що веде до іншої сутності
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name; // Краще зробити поля приватними
    public String email; // Краще зробити поля приватними

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
}