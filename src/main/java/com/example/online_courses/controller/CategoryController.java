package com.example.online_courses.controller;

import com.example.online_courses.entity.Category;
import com.example.online_courses.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Hiển thị danh sách danh mục
    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category-list"; // Trả về template Thymeleaf
    }

    // Hiển thị form thêm danh mục
    @GetMapping("/new")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form"; // Trả về template Thymeleaf
    }

    // Xử lý thêm danh mục
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/categories"; // Chuyển hướng về danh sách
    }

    // Hiển thị form chỉnh sửa danh mục
    @GetMapping("/edit/{id}")
    public String showEditCategoryForm(@PathVariable UUID id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category-form"; // Trả về template Thymeleaf
    }

    // Xóa danh mục
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable UUID id) {
        categoryService.delete(id);
        return "redirect:/categories"; // Chuyển hướng về danh sách
    }
}