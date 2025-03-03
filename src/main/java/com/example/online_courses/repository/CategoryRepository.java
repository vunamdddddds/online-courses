package com.example.online_courses.repository;

import com.example.online_courses.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    // Tìm danh mục theo tên
    Category findByName(String name);
}