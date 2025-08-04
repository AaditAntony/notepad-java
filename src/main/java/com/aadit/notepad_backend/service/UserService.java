package com.aadit.notepad_backend.service;

import com.aadit.notepad_backend.model.User;
import com.aadit.notepad_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
@Autowired
private UserRepository userRepository;

public User createUser(String username,String password){
    User user = User.builder()
            .username(username)
            .password(password)
            .build();
    return userRepository.save(user);
}
public Optional<User> findByUsername(String username){
    return userRepository.findByUsername(username);
}
public Optional<User>getUserById(Long id){
    return userRepository.findById(id);
}
}
