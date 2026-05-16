package com.hardware.users.dto;

public record CreateUserRequest (
    String name,
    String email,
    String password_hash
){}