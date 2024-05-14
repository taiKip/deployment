package com.example.githubactions.comment;

import com.example.githubactions.post.PostNotFoundException;
import com.example.githubactions.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {
	@Autowired
	private CommentService commentService;

	@PostMapping
	public ResponseEntity<Comment> createComment(@RequestBody @Valid CommentRequestDto commentRequestDto)
		throws UserNotFoundException, PostNotFoundException {
		return ResponseEntity.ok(commentService.createComment(commentRequestDto));
	}
}
