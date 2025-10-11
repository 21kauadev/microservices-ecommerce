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
@RequestMapping("/users")
public class UserController {

    // injetar via construtor acaba sendo uma melhor prática para manutenção, testes e prevenir erros de execução!
//    @Autowired
//    private UserService service;

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> findAll() {
        List<User> users = service.findAll();
        ApiResponse<List<User>> response =
                new ApiResponse<List<User>>(HttpStatus.OK.value(), true, "Returned users", users);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> findById(@PathVariable Long id) {
        User user = service.findById(id);
        ApiResponse<User> response =
                new ApiResponse<>(HttpStatus.OK.value(), true, "Found user", user);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<User>> create(@RequestBody UserDTO data) {
        User user = service.create(data);
        ApiResponse<User> response =
                new ApiResponse<>(HttpStatus.OK.value(), true, "Created user", user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> update(@PathVariable("id") Long id, @RequestBody UserDTO data) {
        User user = service.update(id, data);
        ApiResponse<User> response =
                new ApiResponse<>(HttpStatus.OK.value(), true, "Updated user", user);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> delete(@PathVariable("id") Long id) {
        service.delete(id);
        ApiResponse<User> response =
                new ApiResponse<>(HttpStatus.OK.value(), true, "Deleted user", null);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
