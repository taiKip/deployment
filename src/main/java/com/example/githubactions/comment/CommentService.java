package com.example.githubactions.comment;

import com.example.githubactions.post.PostNotFoundException;
import com.example.githubactions.user.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
	Comment createComment(CommentRequestDto commentRequestDto) throws UserNotFoundException, PostNotFoundException;
}
