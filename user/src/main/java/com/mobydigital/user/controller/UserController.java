package com.mobydigital.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobydigital.user.DTO.UserDTO;
import com.mobydigital.user.model.User;
import com.mobydigital.user.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @PutMapping("/addToProject/{userId}/{projectId}")
    public void addToProject(@PathVariable("userId") Long userId, @PathVariable("projectId") Long projectId) {
        userService.addToProject(userId, projectId);
    }
}
