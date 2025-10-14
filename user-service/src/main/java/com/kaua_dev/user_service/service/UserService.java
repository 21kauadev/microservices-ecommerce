package com.kaua_dev.user_service.service;

import com.kaua_dev.user_service.domain.user.User;
import com.kaua_dev.user_service.domain.user.UserDTO;
import com.kaua_dev.user_service.domain.user.exceptions.UserNotFound;
import com.kaua_dev.user_service.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFound::new);
    }

    public User create(UserDTO data) {
        String hashPassword = passwordEncoder().encode(data.password());

        User user = new User();
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPassword(hashPassword);

        return repository.save(user);
    }

    public User update(Long id, UserDTO data) {
        User user = repository.findById(id).orElseThrow(UserNotFound::new);


        if (data.name() != null) user.setName(data.name());
        if (data.email() != null) user.setEmail(data.email());
        if (data.password() != null) {
            String hashPassword = passwordEncoder().encode(data.password());
            user.setPassword(hashPassword);
        }

        return repository.save(user);
    }

    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(UserNotFound::new);

        repository.delete(user);
    }
}
