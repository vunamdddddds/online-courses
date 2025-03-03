package com.example.online_courses.controller;

import com.example.online_courses.entity.Course;
import com.example.online_courses.entity.Category;
import com.example.online_courses.entity.CourseCategory;
import com.example.online_courses.service.CourseService;
import com.example.online_courses.service.CategoryService;
import com.example.online_courses.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/course-categories")
public class CourseCategoryController {
    @Autowired
    private CourseCategoryService courseCategoryService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CategoryService categoryService;

    // Hiển thị danh sách liên kết khóa học - danh mục
    @GetMapping
    public String listCourseCategories(Model model) {
        List<CourseCategory> courseCategories = courseCategoryService.findAll();
        model.addAttribute("courseCategories", courseCategories);
        return "course-category-list"; // Trả về template Thymeleaf
    }

    // Hiển thị form thêm liên kết
    @GetMapping("/new")
    public String showAddCourseCategoryForm(Model model) {
        model.addAttribute("courseCategory", new CourseCategory());
        List<Course> courses = courseService.findAll(); // Lấy danh sách khóa học
        List<Category> categories = categoryService.findAll(); // Lấy danh sách danh mục
        model.addAttribute("courses", courses);
        model.addAttribute("categories", categories);
        return "course-category-form"; // Trả về template Thymeleaf
    }

    // Xử lý thêm liên kết
    @PostMapping("/save")
    public String saveCourseCategory(@ModelAttribute CourseCategory courseCategory) {
        courseCategoryService.save(courseCategory);
        return "redirect:/course-categories"; // Chuyển hướng về danh sách
    }

    // Xóa liên kết (dựa trên course_id và category_id)
    @GetMapping("/delete/{courseId}/{categoryId}")
    public String deleteCourseCategory(@PathVariable UUID courseId, @PathVariable UUID categoryId) {
        List<CourseCategory> courseCategories = courseCategoryService.findByCourseId(courseId);
        for (CourseCategory cc : courseCategories) {
            if (cc.getCategory().getCategoryId().equals(categoryId)) {
                courseCategoryService.delete(cc);
                break;
            }
        }
        return "redirect:/course-categories"; // Chuyển hướng về danh sách
    }
}