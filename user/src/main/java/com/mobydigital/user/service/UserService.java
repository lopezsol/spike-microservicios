package com.mobydigital.user.service;

import com.mobydigital.user.DTO.ProjectDTO;
import com.mobydigital.user.DTO.UserDTO;
import com.mobydigital.user.model.User;
import com.mobydigital.user.repository.ProjectAPI;
import com.mobydigital.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectAPI projectAPI;

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
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        //TODO: modificar
        assert user != null;
        ProjectDTO projectDTO = projectAPI.findProjectById(user.getIdsProject().get(0));
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());

        userDTO.setIdProject(projectDTO.getId());
        userDTO.setNameProject(projectDTO.getName());
        return userDTO;

    }
}
