package com.example.online_courses.service;

import com.example.online_courses.entity.Lesson;
import com.example.online_courses.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    // Lấy tất cả bài giảng
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    // Tìm bài giảng theo ID
    public Lesson findById(String id) {
        return lessonRepository.findById(id).orElse(null);
    }

    // Tìm bài giảng theo course_id
    public List<Lesson> findByCourseId(String courseId) {
        return lessonRepository.findByCourseId(courseId);
    }

    // Tìm bài giảng theo tiêu đề
    public Lesson findByTitle(String title) {
        return lessonRepository.findByTitle(title);
    }

    // Thêm hoặc cập nhật bài giảng
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    // Xóa bài giảng
    public void delete(String id) {
        lessonRepository.deleteById(id);
    }
}