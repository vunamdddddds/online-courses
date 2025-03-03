package com.example.online_courses.controller;

import com.example.online_courses.entity.User;
import com.example.online_courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Hiển thị danh sách người dùng
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list"; // Trả về template Thymeleaf
    }

    // Hiển thị form thêm người dùng
    @GetMapping("/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form"; // Trả về template Thymeleaf
    }

    // Xử lý thêm người dùng
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users"; // Chuyển hướng về danh sách
    }

    // Hiển thị form chỉnh sửa người dùng
    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable UUID id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-form"; // Trả về template Thymeleaf
    }

    // Xóa người dùng
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable UUID id) {
        userService.delete(id);
        return "redirect:/users"; // Chuyển hướng về danh sách
    }
}