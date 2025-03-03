package com.example.online_courses.repository;

import com.example.online_courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    // Tìm khóa học theo tiêu đề (nếu cần)
    Course findByTitle(String title);
}