package com.example.githubactions.post;

import com.example.githubactions.comment.Comment;
import com.example.githubactions.user.User;
import com.example.githubactions.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
	private String title;
	private String content;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "postId", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Comment> comments;

	@Override
	public String toString() {
		return "Post{" +
			"title='" + title + '\'' +
			", content='" + content + '\'' +
			", user=" + user +
			", comments=" + comments +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Post post)) return false;
		if (!super.equals(o)) return false;
		return Objects.equals(getTitle(), post.getTitle()) && Objects.equals(getContent(), post.getContent()) && Objects.equals(getUser(), post.getUser()) && Objects.equals(comments, post.comments);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getTitle(), getContent(), getUser(), comments);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
