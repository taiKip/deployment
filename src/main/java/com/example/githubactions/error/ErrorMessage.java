package com.example.githubactions.error;

import org.springframework.http.HttpStatus;

public record ErrorMessage(HttpStatus httpStatus,String message) {
}
