package com.farhad.tms.controller;

import com.farhad.tms.dto.request.UserRequestDTO;
import com.farhad.tms.dto.response.CustomUserResponse;
import com.farhad.tms.dto.response.UserResponseDTO;
import com.farhad.tms.model.User;
import com.farhad.tms.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/customUserResponse")
    public ResponseEntity<List<CustomUserResponse>> findAllCustomUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/userResponse")
    public ResponseEntity<List<UserResponseDTO>> findAllUserResponse() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User findUser = userService.findUserById(id);
        return new ResponseEntity<>(findUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        User updatedUser = userService.updateUser(id, userRequestDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}

























