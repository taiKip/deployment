package com.example.githubactions.user;

import java.time.LocalDateTime;

public record UserResponseDto(
        String firstname,
        String lastname,
        String username,
        String email
) {
}
