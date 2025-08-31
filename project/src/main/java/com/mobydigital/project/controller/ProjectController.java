package com.mobydigital.project.controller;

import com.mobydigital.project.model.Project;
import com.mobydigital.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin

public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> findAll(){
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project findProjectById(@PathVariable Long id){
        return projectService.findProjectById(id);
    }

    @PostMapping
    public void createProject(@RequestBody Project project){
        projectService.createProject(project);
    }
}
