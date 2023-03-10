package com.backend.service;

import com.backend.domain.User;
import com.backend.exceptions.MyEntityNotFoundException;
import com.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDbService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) throws MyEntityNotFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new MyEntityNotFoundException("User", userId));
    }

    public User getUser(String username) throws MyEntityNotFoundException {
        return userRepository.findByUsername(username ).orElseThrow(() -> new MyEntityNotFoundException("Username: " + username));
    }

    public void saveUser(User user) {
        if (user.getCreatedDate() == null) {
            user.setCreatedDate(LocalDateTime.now());
        }
        userRepository.save(user);
    }

    public User updateUser(User user) throws MyEntityNotFoundException {
        if(userRepository.findById(user.getId()).isPresent()) {
            return userRepository.save(user);
        } else {
            throw new MyEntityNotFoundException("User", user.getId());
        }
    }

    public void deleteUser(Long userId) throws MyEntityNotFoundException {
        if(userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new MyEntityNotFoundException("User", userId);
        }
    }
}
