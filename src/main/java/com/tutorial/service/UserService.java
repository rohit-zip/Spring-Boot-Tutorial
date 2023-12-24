package com.tutorial.service;

import com.tutorial.dto.UserDto;

import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.service
 * Created_on - 06 December-2023
 * Created_at - 20 : 44
 */

public interface UserService {

    UserDto addUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUser();
    void deleteUser(Long id);
    UserDto updateUser(Long id, UserDto userDto);
    List<UserDto> getUserByEmail(String email);
    List<UserDto> getUserByName(String name);
}
