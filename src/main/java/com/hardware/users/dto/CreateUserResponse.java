package com.hardware.users.dto;

import lombok.Builder;

@Builder
public record CreateUserResponse(
    Long id,
    String name,
    String email
) {}
