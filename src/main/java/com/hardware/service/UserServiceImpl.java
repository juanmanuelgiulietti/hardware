package com.hardware.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hardware.entity.User;
import com.hardware.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        if (userRepository.existsByUsername(user.getName())) {
            throw new IllegalArgumentException("Name already in use.");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        String encryptedPassword = passwordEncoder.encode(user.getPassword_hash());

        user.setPassword_hash(encryptedPassword);

        return userRepository.save(user);
    }
}
