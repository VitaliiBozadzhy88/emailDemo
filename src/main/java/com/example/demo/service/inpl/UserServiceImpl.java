package com.example.demo.service.inpl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllByEmail(String email) {
        return userRepository.getAllByEmail(email);
    }

    @Override
    public String getActivationCode(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public Integer getId(String email) {
        return userRepository.getId(email);
    }

    @Override
    public void updateStatus(String status, Integer id) {
        userRepository.update(status, id);
    }

    @Override
    public void updateDescription(String description, Integer id) {
        userRepository.updateDescription(description, id);
    }

    @Override
    public String getStatus(String email) {
        return userRepository.getStatus(email);
    }

    @Override
    public Optional<String> getEmail(String email) {
        return userRepository.getEmail(email);
    }

    @Override
    public String getDescription(String email) {
        return userRepository.getDescription(email);
    }
}
