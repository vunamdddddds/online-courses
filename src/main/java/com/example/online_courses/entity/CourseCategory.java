package com.example.online_courses.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Course_Category")
@Data
public class CourseCategory {
    @Id
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category category;
}