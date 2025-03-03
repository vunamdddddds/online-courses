package com.example.online_courses.service;

import com.example.online_courses.entity.Course;
import com.example.online_courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    // Lấy tất cả khóa học
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    // Tìm khóa học theo ID
    public Course findById(UUID id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Tìm khóa học theo tiêu đề
    public Course findByTitle(String title) {
        return courseRepository.findByTitle(title);
    }

    // Thêm hoặc cập nhật khóa học
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    // Xóa khóa học
    public void delete(UUID id) {
        courseRepository.deleteById(id);
    }
}