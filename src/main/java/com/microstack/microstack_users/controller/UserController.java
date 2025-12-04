package com.microstack.microstack_users.controller;

import com.microstack.microstack_users.dto.UserRequest;
import com.microstack.microstack_users.entity.User;
import com.microstack.microstack_users.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody UserRequest request) {
        return userService.create(request);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody UserRequest request) {
        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}

