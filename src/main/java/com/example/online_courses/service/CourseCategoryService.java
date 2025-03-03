package com.example.online_courses.service;

import com.example.online_courses.entity.CourseCategory;
import com.example.online_courses.repository.CourseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseCategoryService {
    @Autowired
    private CourseCategoryRepository courseCategoryRepository;

    // Lấy tất cả bản ghi Course_Category
    public List<CourseCategory> findAll() {
        return courseCategoryRepository.findAll();
    }

    // Tìm danh mục của một khóa học
    public List<CourseCategory> findByCourseId(UUID courseId) {
        return courseCategoryRepository.findByCourseCourseId(courseId);
    }

    // Tìm khóa học của một danh mục
    public List<CourseCategory> findByCategoryId(UUID categoryId) {
        return courseCategoryRepository.findByCategoryCategoryId(categoryId);
    }

    // Thêm hoặc cập nhật bản ghi
    public CourseCategory save(CourseCategory courseCategory) {
        return courseCategoryRepository.save(courseCategory);
    }

    // Xóa bản ghi
    public void delete(CourseCategory courseCategory) {
        courseCategoryRepository.delete(courseCategory);
    }
}