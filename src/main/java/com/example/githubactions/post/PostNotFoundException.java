package com.example.githubactions.post;

public class PostNotFoundException extends Exception{
	public PostNotFoundException(String message) {
		super(message);
	}
}
