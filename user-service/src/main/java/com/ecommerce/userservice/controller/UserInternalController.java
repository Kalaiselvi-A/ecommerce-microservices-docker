package com.ecommerce.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.userservice.dto.UserInternalResponseDTO;
import com.ecommerce.userservice.service.UserService;

@RestController
@RequestMapping("/internal/users")
public class UserInternalController {

    private final UserService userService;

    public UserInternalController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserInternalResponseDTO getUserForInternal(
            @PathVariable Long userId) {

        return userService.getUserInternal(userId);
    }
}
