package com.ecommerce.userservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.userservice.dto.UserRequestDTO;
import com.ecommerce.userservice.dto.UserResponseDTO;
import com.ecommerce.userservice.dto.UserUpdateRequestDTO;
import com.ecommerce.userservice.entity.User;
import com.ecommerce.userservice.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }
    
    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
    	return ResponseEntity.ok(userService.getUserById(id));
    }
    
    // Get All Users
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    	return ResponseEntity.ok(userService.getAllUsers());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDTO request) {
        
        return ResponseEntity.ok(userService.updateUser(id, request));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
    	return ResponseEntity.noContent().build();
    	
    }
    
}