package com.hardware.users.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hardware.users.dto.CreateUserRequest;
import com.hardware.users.dto.CreateUserResponse;
import com.hardware.users.entity.User;
import com.hardware.users.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {

    if (userRepository.existsByUsername(request.name())) {
        throw new IllegalArgumentException("Name already in use.");
    }

    if (userRepository.existsByEmail(request.email())) {
        throw new IllegalArgumentException("Email already in use.");
    }

    User user = User.builder()
            .name(request.name())
            .email(request.email())
            .password_hash(request.password_hash())
            .build();

    User saveUser = saveUser(user);

    return CreateUserResponse.builder()
            .id(saveUser.getId_user())
            .name(saveUser.getName())
            .email(saveUser.getEmail())
            .build();
}

    @Override
    public User saveUser(User user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword_hash());
        user.setPassword_hash(encryptedPassword);

        return userRepository.save(user);
    }
}
