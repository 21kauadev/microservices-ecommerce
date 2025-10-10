package com.kaua_dev.user_service.controller;

import com.kaua_dev.user_service.domain.user.User;
import com.kaua_dev.user_service.infra.ApiResponse;
import com.kaua_dev.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> users = service.getAllUsers();
        ApiResponse<List<User>> response =
                new ApiResponse<List<User>>(HttpStatus.OK.value(), true, "Returned users", users);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable Long id) {
        User user = service.getUser(id);
        ApiResponse<User> response =
                new ApiResponse<>(HttpStatus.OK.value(), true, "Found user", user);

        return ResponseEntity.ok().body(response);
    }
}
