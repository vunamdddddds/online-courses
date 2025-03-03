package com.example.online_courses.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Document(collection = "lessons")
@Data
public class Lesson {
    @Id
    private String id; // ObjectId trong MongoDB

    private String courseId; // Liên kết với course_id trong SQL Server

    private String title;

    private String videoUrl;

    private String content;

    private int duration;

    private int order;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}