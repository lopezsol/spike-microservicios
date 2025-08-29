package com.mobydigital.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobydigital.user.DTO.LocalidadDTO;
import com.mobydigital.user.DTO.ProjectDTO;
import com.mobydigital.user.DTO.ProvinciaDTO;
import com.mobydigital.user.DTO.UserDTO;
import com.mobydigital.user.model.User;
import com.mobydigital.user.repository.GeorefAPI;
import com.mobydigital.user.repository.ProjectAPI;
import com.mobydigital.user.repository.UserRepository;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    // Conexión con microservicio project
    @Autowired
    ProjectAPI projectAPI;

    // Conexión con microservicio georef
    @Autowired
    GeorefAPI georefAPI;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setIdProvince(updatedUser.getIdProvince());
            user.setIdLocality(updatedUser.getIdLocality());
            user.setCurrentTechnology(updatedUser.getCurrentTechnology());
            user.setReferent(updatedUser.getReferent());
            user.setTalentPartner(updatedUser.getTalentPartner());
            user.setIdsProject(updatedUser.getIdsProject());
        }
        userRepository.save(user);
    }

    @Override
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        List<ProjectDTO> projects = new ArrayList<>();

        if (user != null) {
            // ProjectDTO projectDTO = projectAPI.findProjectById(user.getIdsProject().get(0));

            for(Long ProjectId : user.getIdsProject()) {
                projects.add(projectAPI.findProjectById(ProjectId));
            }

            ProvinciaDTO provincia = georefAPI.getProvinciaById(user.getIdProvince());
            LocalidadDTO municipio = georefAPI.getLocalidadById(user.getIdLocality());

            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            // userDTO.setName(user.getName());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setProvince(provincia);
            userDTO.setLocality(municipio);
            userDTO.setCurrentTechnology(user.getCurrentTechnology());
            userDTO.setReferent(user.getReferent());
            userDTO.setTalentPartner(user.getTalentPartner());
            userDTO.setProjects(projects);

            return userDTO;
        }
        return null; 
    }
}
