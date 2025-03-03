package com.example.online_courses.controller;

import com.example.online_courses.entity.Course;
import com.example.online_courses.entity.Lesson;
import com.example.online_courses.service.CourseService;
import com.example.online_courses.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @Autowired
    private CourseService courseService;

    // Hiển thị danh sách bài giảng
    @GetMapping
    public String listLessons(Model model) {
        List<Lesson> lessons = lessonService.findAll();
        model.addAttribute("lessons", lessons);
        return "lesson-list"; // Trả về template Thymeleaf
    }

    // Hiển thị form thêm bài giảng
    @GetMapping("/new")
    public String showAddLessonForm(Model model) {
        model.addAttribute("lesson", new Lesson());
        List<Course> courses = courseService.findAll(); // Lấy danh sách khóa học
        model.addAttribute("courses", courses);
        return "lesson-form"; // Trả về template Thymeleaf
    }

    // Xử lý thêm bài giảng
    @PostMapping("/save")
    public String saveLesson(@ModelAttribute Lesson lesson) {
        lessonService.save(lesson);
        return "redirect:/lessons"; // Chuyển hướng về danh sách
    }

    // Hiển thị form chỉnh sửa bài giảng
    @GetMapping("/edit/{id}")
    public String showEditLessonForm(@PathVariable String id, Model model) {
        Lesson lesson = lessonService.findById(id);
        model.addAttribute("lesson", lesson);
        List<Course> courses = courseService.findAll(); // Lấy danh sách khóa học
        model.addAttribute("courses", courses);
        return "lesson-form"; // Trả về template Thymeleaf
    }

    // Xóa bài giảng
    @GetMapping("/delete/{id}")
    public String deleteLesson(@PathVariable String id) {
        lessonService.delete(id);
        return "redirect:/lessons"; // Chuyển hướng về danh sách
    }
}