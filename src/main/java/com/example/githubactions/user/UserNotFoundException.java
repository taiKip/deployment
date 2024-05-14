package com.example.githubactions.user;

public class UserNotFoundException extends Exception{
	public UserNotFoundException(String message) {
		super(message);
	}
}
