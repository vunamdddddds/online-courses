package com.example.online_courses.repository;

import com.example.online_courses.entity.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LessonRepository extends MongoRepository<Lesson, String> {
    // Tìm bài giảng theo course_id
    List<Lesson> findByCourseId(String courseId);

    // Tìm bài giảng theo tiêu đề
    Lesson findByTitle(String title);
}