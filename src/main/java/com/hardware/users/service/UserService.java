package com.hardware.users.service;

import com.hardware.users.dto.CreateUserRequest;
import com.hardware.users.dto.CreateUserResponse;
import com.hardware.users.entity.User;

public interface UserService {
    User saveUser(User user);
    CreateUserResponse createUser(CreateUserRequest request);
}
