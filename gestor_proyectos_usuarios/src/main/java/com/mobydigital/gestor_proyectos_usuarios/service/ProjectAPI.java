package com.mobydigital.gestor_proyectos_usuarios.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mobydigital.gestor_proyectos_usuarios.dto.Project;

@FeignClient(name = "project")
public interface ProjectAPI {
    @GetMapping("projects/{id}")
    public Project findProjectById(@PathVariable Long id);
}
