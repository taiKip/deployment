package com.example.githubactions.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> fetchUsers();

    User createUser(UserRequestDto userRequestDto);
}
