package com.tutorial.implementation;

import com.tutorial.dto.UserDto;
import com.tutorial.entity.User;
import com.tutorial.repository.UserRepository;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.implementation
 * Created_on - 06 December-2023
 * Created_at - 20 : 51
 */

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDto) {
        String name = userDto.getName();
        String email = userDto.getEmail();
        String password = userDto.getPassword();
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setIsEnabled(false);
        user.setDateRegistered(LocalDate.now());
        user.setTimeRegistered(LocalTime.now());
        User savedUser = userRepository.save(user);
        UserDto response = new UserDto();
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        return response;
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> getUserByName(String name) {
        return null;
    }
}
