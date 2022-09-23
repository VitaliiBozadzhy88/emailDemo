package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);

    List<User> getAllByEmail(String email);

    String getActivationCode(String email);

    Integer getId(String email);

    void updateStatus (String status, Integer id);

    void updateDescription(String description, Integer id);

    String getStatus(String email);

    Optional<String> getEmail(String email);

    String getDescription(String email);
}
