package com.example.githubactions.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record UserRequestDto(@NotBlank(message = "Please provide a username") String firstname,
                             @NotBlank(message = "Please provide a lastname") String lastname,
                             @NotBlank(message = "Please provide a username") String username,
                             @Email(message = "Please provide a valid email address") @NotBlank String email) {
}
