package com.example.online_courses.repository;

import com.example.online_courses.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
    // Tìm giao dịch theo user_id và course_id
    List<Purchase> findByUserUserIdAndCourseCourseId(UUID userId, UUID courseId);

    // Tìm tất cả giao dịch của một người dùng
    List<Purchase> findByUserUserId(UUID userId);
}