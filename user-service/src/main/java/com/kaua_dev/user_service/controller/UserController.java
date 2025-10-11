package com.kaua_dev.user_service.controller;

import com.kaua_dev.user_service.domain.user.User;
import com.kaua_dev.user_service.domain.user.UserDTO;
import com.kaua_dev.user_service.infra.ApiResponse;
import com.kaua_dev.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody UserDTO data) {
        User user = service.createUser(data);
        ApiResponse<User> response =
                new ApiResponse<>(HttpStatus.OK.value(), true, "Created user", user);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO data) {
        User user = service.updateUser(id, data);
        ApiResponse<User> response =
                new ApiResponse<>(HttpStatus.OK.value(), true, "Updated user", user);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/delete")
    public ResponseEntity<ApiResponse<User>> deleteUser(@PathVariable("id") Long id, @RequestBody UserDTO data) {
        User user = service.updateUser(id, data);
        ApiResponse<User> response =
                new ApiResponse<>(HttpStatus.OK.value(), true, "Updated user", user);

        return ResponseEntity.ok().body(response);
    }
}
