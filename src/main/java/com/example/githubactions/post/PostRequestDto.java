package com.example.githubactions.post;

import jakarta.validation.constraints.*;

 public record PostRequestDto(
	@NotNull(message = "User id is required")
	Long userId,
	@NotNull(message = "Title is required")
	String title,
	@NotBlank(message = "Content is required")
	String content
) {
	 static Long MAXIMUM = Long.MAX_VALUE;

 }
