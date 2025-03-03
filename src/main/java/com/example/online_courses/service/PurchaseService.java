package com.example.online_courses.service;

import com.example.online_courses.entity.Purchase;
import com.example.online_courses.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    // Lấy tất cả giao dịch
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    // Tìm giao dịch theo ID
    public Purchase findById(UUID id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    // Tìm giao dịch theo user_id và course_id
    public List<Purchase> findByUserAndCourse(UUID userId, UUID courseId) {
        return purchaseRepository.findByUserUserIdAndCourseCourseId(userId, courseId);
    }

    // Tìm tất cả giao dịch của một người dùng
    public List<Purchase> findByUserId(UUID userId) {
        return purchaseRepository.findByUserUserId(userId);
    }

    // Thêm hoặc cập nhật giao dịch
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    // Xóa giao dịch
    public void delete(UUID id) {
        purchaseRepository.deleteById(id);
    }
}