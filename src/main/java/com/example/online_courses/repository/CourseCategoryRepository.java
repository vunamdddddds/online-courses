package com.example.online_courses.repository;

import com.example.online_courses.entity.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Void> {
    // Tìm danh mục của một khóa học
    List<CourseCategory> findByCourseCourseId(UUID courseId);

    // Tìm khóa học của một danh mục
    List<CourseCategory> findByCategoryCategoryId(UUID categoryId);
}