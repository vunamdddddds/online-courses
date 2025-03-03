package com.example.online_courses.service;

import com.example.online_courses.entity.User;
import com.example.online_courses.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Lấy tất cả người dùng
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Tìm người dùng theo ID
    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    // Tìm người dùng theo email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Thêm hoặc cập nhật người dùng
    public User save(User user) {
        return userRepository.save(user);
    }

    // Xóa người dùng
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}