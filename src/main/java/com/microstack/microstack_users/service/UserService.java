package com.microstack.microstack_users.service;

import com.microstack.microstack_users.dto.UserRequest;
import com.microstack.microstack_users.entity.User;
import com.microstack.microstack_users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User create(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User(request.getEmail(), request.getName());
        return userRepository.save(user);
    }

    public User update(Long id, UserRequest request) {
        User user = findById(id);
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

