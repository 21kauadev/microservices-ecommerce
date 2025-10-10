package com.kaua_dev.user_service.service;

import com.kaua_dev.user_service.domain.user.User;
import com.kaua_dev.user_service.domain.user.exceptions.UserNotFound;
import com.kaua_dev.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }
    public User getUser(Long id) {
        return repository.findById(id).orElseThrow(UserNotFound::new);
    }
}
