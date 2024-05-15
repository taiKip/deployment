package com.example.githubactions.comment;

public record CommentResponseDto(String username,Long userId,String comment,Long id,Long postId) {
}
