package com.tutorial.implementation;

import com.tutorial.dto.UserDto;
import com.tutorial.entity.User;
import com.tutorial.repository.UserRepository;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
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

        //        user.setDateRegistered(new Date());
//        user.setDateRegistered(Date.from(Instant.now()));
//        user.setDateRegistered(new Date(System.currentTimeMillis()));

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setIsEnabled(false);
        user.setDateRegistered(LocalDate.now());
        user.setTimeRegistered(LocalTime.now());

        User savedUser = userRepository.save(user);
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
