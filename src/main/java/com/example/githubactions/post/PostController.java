package com.example.githubactions.post;

import com.example.githubactions.user.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
public class PostController {
	@Autowired
	private final PostService postService;

	@PostMapping
	public ResponseEntity<Post> createPost(@RequestBody @Valid PostRequestDto postRequestDto) throws UserNotFoundException {
		return ResponseEntity.ok(postService.createPost(postRequestDto));
	}

	@GetMapping
	public ResponseEntity<List<Post>> getPosts() {
		return ResponseEntity.ok(postService.getPosts());
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Post> getPost(@PathVariable("id") Long id) throws PostNotFoundException {
		return ResponseEntity.ok(postService.getPost(id));
	}

}
