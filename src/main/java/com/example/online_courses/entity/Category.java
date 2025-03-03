package com.example.online_courses.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Categories")
@Data
public class Category {
    @Id
    @Column(name = "category_id", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID categoryId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (categoryId == null) {
            categoryId = UUID.randomUUID();
        }
    }
}