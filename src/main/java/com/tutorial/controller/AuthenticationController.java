package com.tutorial.controller;

import com.tutorial.authentication.JwtGenerator;
import com.tutorial.dto.ApiResponse;
import com.tutorial.dto.LoginData;
import com.tutorial.entity.User;
import com.tutorial.exception.BadRequestException;
import com.tutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.controller
 * Created_on - 20 January-2024
 * Created_at - 21 : 34
 */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginData loginData) {
        User user = userRepository.findByEmail(loginData.getEmail());
//        if (user == null) throw new BadRequestException("User not found with email");
        if (Objects.isNull(user)) throw new BadRequestException("User not found with email");
//        if (ObjectUtils.isEmpty(user)) throw new BadRequestException("User not found with email");
        String password = user.getPassword(); // encoded
        boolean matches = passwordEncoder.matches(loginData.getPassword(), password);
//        if (!matches) throw new BadRequestException("Password is not correct");
        if (Boolean.FALSE.equals(matches)) throw new BadRequestException("Password is not correct");
        JwtGenerator jwtGenerator = new JwtGenerator();
        String token = jwtGenerator.generateToken(user);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(token);
        //ResponseEntity responseEntity = new ResponseEntity(apiResponse, HttpStatus.OK);
        //return responseEntity;

        return ResponseEntity.ok(apiResponse);
//        return apiResponse;
    }
}
