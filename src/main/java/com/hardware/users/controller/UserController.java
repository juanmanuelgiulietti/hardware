package com.hardware.users.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardware.users.dto.CreateUserRequest;
import com.hardware.users.dto.CreateUserResponse;
import com.hardware.users.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name="Users", description="User endpoints")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }
    
}
