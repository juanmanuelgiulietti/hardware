package com.hardware.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request body for creating a new user")
public record CreateUserRequest (
    @Schema(description = "The name of the user", example = "John Doe")
    @NotBlank(message = "Name is required")
    String name,

    @Schema(description = "The email of the user", example = "john.doe@example.com")
    @NotBlank(message = "Email is required")
    String email,

    @Schema(description = "The hashed password of the user", example = "hashed_password_here")
    @NotBlank(message = "Password hash is required")
    String password_hash
){}