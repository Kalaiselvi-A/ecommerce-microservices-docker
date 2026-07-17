package com.ecommerce.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.orderservice.dto.UserResponse;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/internal/users/{userId}")
    UserResponse getUserById(@PathVariable Long userId);
}
