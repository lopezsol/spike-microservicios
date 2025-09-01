package com.mobydigital.user.service;

import com.mobydigital.user.DTO.UserDTO;
import com.mobydigital.user.model.User;

import java.util.List;

public interface IUserService {
    public List<User> findAll();
    public void createUser(User user);
    public void deleteUser(Long id);
    public void updateUser(Long id, User updatedUser);
    public void addToProject(Long userId, Long projectId);
    public UserDTO findUserById(Long id);
}
