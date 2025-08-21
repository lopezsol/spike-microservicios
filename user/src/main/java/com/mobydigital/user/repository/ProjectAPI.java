package com.mobydigital.user.repository;

import com.mobydigital.user.DTO.ProjectDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "project")
public interface ProjectAPI {
    @GetMapping("projects/{id}")
    public ProjectDTO findProjectById(@PathVariable Long id);
}
