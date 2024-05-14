package com.example.githubactions.post;

import com.example.githubactions.user.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
	Post createPost(PostRequestDto postRequestDto) throws UserNotFoundException;

	List<Post> getPosts();
}
