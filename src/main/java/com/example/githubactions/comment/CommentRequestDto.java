package com.example.githubactions.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentRequestDto(@NotNull Long postId, @NotNull Long userId, @NotBlank String content) {
}
