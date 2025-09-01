package com.mobydigital.gestor_proyectos_usuarios.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mobydigital.gestor_proyectos_usuarios.DTO.User;

@FeignClient(name = "user")
public interface UserAPI {
    @GetMapping("/users")
    public List<User> getAllUsers();

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user);
}