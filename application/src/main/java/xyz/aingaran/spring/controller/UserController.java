package xyz.aingaran.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.aingaran.spring.exception.ResourceNotFoundException;
import xyz.aingaran.spring.model.User;
import xyz.aingaran.spring.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        logger.info("Requested to get All Users.");
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        logger.info("Requested to posting the User info.");
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long noteId) {
        logger.info("Requested to get userId" +noteId);
        return userRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", noteId));
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody User userDetails) {
        logger.info("Requested to update userId" +noteId);
        User user = userRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", noteId));

        user.setTitle(userDetails.getTitle());
        user.setName(userDetails.getName());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        logger.info("Requested to delete userId" +userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
