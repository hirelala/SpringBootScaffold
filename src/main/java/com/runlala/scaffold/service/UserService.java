package com.runlala.scaffold.service;

import com.runlala.scaffold.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isEmailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
