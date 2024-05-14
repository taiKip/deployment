package com.example.githubactions.comment;

import com.example.githubactions.post.Post;
import com.example.githubactions.post.PostNotFoundException;
import com.example.githubactions.post.PostRepository;
import com.example.githubactions.user.User;
import com.example.githubactions.user.UserNotFoundException;
import com.example.githubactions.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comment createComment(CommentRequestDto commentRequestDto) throws UserNotFoundException, PostNotFoundException {
		Optional<User> foundUser = userRepository.findById(commentRequestDto.userId());
		Optional<Post> foundPost = postRepository.findById(commentRequestDto.postId());
		if (foundPost.isEmpty()) {
			throw new PostNotFoundException("post not found");

		}
		if (foundUser.isEmpty()) {
			throw new UserNotFoundException("user not found");
		}

		Comment newComment = Comment.builder()
			.content(commentRequestDto.content()).postId(foundPost.get()).userId(foundUser.get()).build();
		return commentRepository.save(newComment);
	}
}
