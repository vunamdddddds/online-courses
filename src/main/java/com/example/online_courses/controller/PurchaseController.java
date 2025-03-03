package com.example.online_courses.controller;

import com.example.online_courses.entity.Course;
import com.example.online_courses.entity.Purchase;
import com.example.online_courses.entity.User;
import com.example.online_courses.service.CourseService;
import com.example.online_courses.service.PurchaseService;
import com.example.online_courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    // Hiển thị danh sách giao dịch
    @GetMapping
    public String listPurchases(Model model) {
        List<Purchase> purchases = purchaseService.findAll();
        model.addAttribute("purchases", purchases);
        return "purchase-list"; // Trả về template Thymeleaf
    }

    // Hiển thị form thêm giao dịch
    @GetMapping("/new")
    public String showAddPurchaseForm(Model model) {
        model.addAttribute("purchase", new Purchase());
        List<User> users = userService.findAll(); // Lấy danh sách người dùng
        List<Course> courses = courseService.findAll(); // Lấy danh sách khóa học
        model.addAttribute("users", users);
        model.addAttribute("courses", courses);
        return "purchase-form"; // Trả về template Thymeleaf
    }

    // Xử lý thêm giao dịch
    @PostMapping("/save")
    public String savePurchase(@ModelAttribute Purchase purchase) {
        purchaseService.save(purchase);
        return "redirect:/purchases"; // Chuyển hướng về danh sách
    }

    // Hiển thị form chỉnh sửa giao dịch
    @GetMapping("/edit/{id}")
    public String showEditPurchaseForm(@PathVariable UUID id, Model model) {
        Purchase purchase = purchaseService.findById(id);
        model.addAttribute("purchase", purchase);
        List<User> users = userService.findAll(); // Lấy danh sách người dùng
        List<Course> courses = courseService.findAll(); // Lấy danh sách khóa học
        model.addAttribute("users", users);
        model.addAttribute("courses", courses);
        return "purchase-form"; // Trả về template Thymeleaf
    }

    // Xóa giao dịch
    @GetMapping("/delete/{id}")
    public String deletePurchase(@PathVariable UUID id) {
        purchaseService.delete(id);
        return "redirect:/purchases"; // Chuyển hướng về danh sách
    }
}