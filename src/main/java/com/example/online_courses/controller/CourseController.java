package com.example.online_courses.controller;

import com.example.online_courses.entity.Course;
import com.example.online_courses.entity.User;
import com.example.online_courses.service.CourseService;
import com.example.online_courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    // Hiển thị danh sách khóa học
    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "course-list"; // Trả về template Thymeleaf
    }

    // Hiển thị form thêm khóa học
    @GetMapping("/new")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        List<User> instructors = userService.findAll(); // Lấy danh sách giảng viên
        model.addAttribute("instructors", instructors);
        return "course-form"; // Trả về template Thymeleaf
    }

    // Xử lý thêm khóa học
    @PostMapping("/save")
    public String saveCourse(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/courses"; // Chuyển hướng về danh sách
    }

    // Hiển thị form chỉnh sửa khóa học
    @GetMapping("/edit/{id}")
    public String showEditCourseForm(@PathVariable UUID id, Model model) {
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        List<User> instructors = userService.findAll(); // Lấy danh sách giảng viên
        model.addAttribute("instructors", instructors);
        return "course-form"; // Trả về template Thymeleaf
    }

    // Xóa khóa học
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable UUID id) {
        courseService.delete(id);
        return "redirect:/courses"; // Chuyển hướng về danh sách
    }
}