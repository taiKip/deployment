package com.example.githubactions.post;

import com.example.githubactions.user.User;
import com.example.githubactions.user.UserNotFoundException;
import com.example.githubactions.user.UserRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private  PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;
	@Override
	public Post createPost(PostRequestDto postRequestDto) throws UserNotFoundException {
Optional<User> foundUser = userRepository.findById(postRequestDto.userId());
if(foundUser.isEmpty()){
	throw new UserNotFoundException("User does not exist");
}
Post newPost = Post.builder()
	.title(postRequestDto.title())
	.content(postRequestDto.content())
	.user(foundUser.get())
	.build();
		return postRepository.save(newPost);
	}

	@Override
	public List<Post> getPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post getPost(Long id) throws PostNotFoundException {
		Optional<Post> foundPost = postRepository.findById(id);
		if(foundPost.isEmpty()){
			throw new PostNotFoundException("Post not found");
		}
		return foundPost.get();
	}
}
