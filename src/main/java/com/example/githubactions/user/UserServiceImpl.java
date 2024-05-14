package com.example.githubactions.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserRequestDto userRequestDto) {

        User newUser = User.builder()
                .email(userRequestDto.email())
                .firstname(userRequestDto.firstname())
                .lastname(userRequestDto.lastname())
                .username(userRequestDto.username())
                .build();
        return userRepository.save(newUser);
    }
}
