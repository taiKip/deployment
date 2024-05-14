package com.example.githubactions.comment;

import com.example.githubactions.post.Post;
import com.example.githubactions.user.User;
import com.example.githubactions.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {
	private String content;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userId;
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post postId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Post getPostId() {
		return postId;
	}

	public void setPostId(Post postId) {
		this.postId = postId;
	}
}
