package com.example.githubactions.post;

import com.example.githubactions.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class PostServiceTest {
	private static  final long TEST_ID = 1L;
	@MockBean
	private PostRepository postRepository;
	@Autowired
	private PostService postService;
@BeforeEach()
void setUp(){
	Post post = new Post();
	post.setId(TEST_ID);
	post.setTitle("Test");
	post.setContent("test");


Mockito.when(postRepository.findById(TEST_ID)).thenReturn(Optional.of(post));
}




	@Test
	void testProcessFindPostByUseId() throws PostNotFoundException {
Long id = 1L;
Optional<Post> foundPost = Optional.ofNullable(postService.getPost(id));
assertEquals(foundPost.get().getId(),id);
	}
}
