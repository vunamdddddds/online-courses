package com.example.online_courses.service;

import com.example.online_courses.entity.Category;
import com.example.online_courses.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // Lấy tất cả danh mục
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Tìm danh mục theo ID
    public Category findById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // Tìm danh mục theo tên
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    // Thêm hoặc cập nhật danh mục
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    // Xóa danh mục
    public void delete(UUID id) {
        categoryRepository.deleteById(id);
    }
}