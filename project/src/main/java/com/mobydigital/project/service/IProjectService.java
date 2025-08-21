package com.mobydigital.project.service;

import com.mobydigital.project.model.Project;

import java.util.List;

public interface IProjectService {
    public List<Project> findAll();
    public void createProject(Project project);
    public void deleteProject(Long id);
    public Project findProjectById(Long id);
}
