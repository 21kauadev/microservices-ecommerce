package com.kaua_dev.user_service.service;

import com.kaua_dev.user_service.domain.user.User;
import com.kaua_dev.user_service.domain.user.UserDTO;
import com.kaua_dev.user_service.domain.user.exceptions.UserNotFound;
import com.kaua_dev.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFound::new);
    }

    public User create(UserDTO data) {
        User user = new User();
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPassword(data.password());

        return repository.save(user);
    }

    public User update(Long id, UserDTO data) {
        User user = repository.findById(id).orElseThrow(UserNotFound::new);

        if (data.name() != null) user.setName(data.name());
        if (data.email() != null) user.setEmail(data.email());
        if (data.password() != null) user.setPassword(data.password());

        return repository.save(user);
    }

    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(UserNotFound::new);

        repository.delete(user);
    }
}
