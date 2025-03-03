package com.example.online_courses.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Purchases")
@Data
public class Purchase {
    @Id
    @Column(name = "purchase_id", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID purchaseId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private Course course;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "status", length = 50)
    private String status = "pending";

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Column(name = "transaction_id", length = 255)
    private String transactionId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (purchaseId == null) {
            purchaseId = UUID.randomUUID();
        }
    }
}