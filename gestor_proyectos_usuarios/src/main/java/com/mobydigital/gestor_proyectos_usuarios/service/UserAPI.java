package com.mobydigital.gestor_proyectos_usuarios.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mobydigital.gestor_proyectos_usuarios.dto.User;
import com.mobydigital.gestor_proyectos_usuarios.dto.UserDTO;

@FeignClient(name = "user")
public interface UserAPI {
    @GetMapping("users/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id);

    @PutMapping("users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user);
}