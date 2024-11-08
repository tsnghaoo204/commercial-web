package com.commercial_website.Services;

import com.commercial_website.DTOs.UserDTO;

import java.util.Set;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    Set<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    Set<UserDTO> getUsersByRole(String role);
    Set<UserDTO> getAllUsersByElements(String addressDetail, String ward, String district, String province, String fullname); ;
}
