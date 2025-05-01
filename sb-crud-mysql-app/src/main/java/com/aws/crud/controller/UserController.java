package com.aws.crud.controller;

import com.aws.crud.entity.User;
import com.aws.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value="id") long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found: "+id));
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable long id) {
        User existingUser = getUserById(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        User user = getUserById(id);
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
