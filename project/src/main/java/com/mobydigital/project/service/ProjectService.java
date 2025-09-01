package com.mobydigital.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mobydigital.project.model.Project;
import com.mobydigital.project.repository.ProjectRepository;

@Service
public class ProjectService implements IProjectService{
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void createProject(Project project) {
        projectRepository.save(project);
        kafkaTemplate.send("mentoria-back-topic", "Creado el proyecto " + project.getName() + " correctamente.");
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
        kafkaTemplate.send("mentoria-back-topic", "Eliminado el proyecto con ID " + id + " correctamente.");
    }

    @Override
    public Project findProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
}
