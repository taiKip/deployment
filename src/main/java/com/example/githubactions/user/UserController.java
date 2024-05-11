package com.example.githubactions.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @GetMapping
    public ResponseEntity<List<String>>  fetchUsers(){
        List<String> users = new ArrayList<>();
        users.add("Victor");
        users.add("Ken");
        users.add("Gilbert");
        users.add("Jesse");
        return ResponseEntity.ok(users);
    }
}
