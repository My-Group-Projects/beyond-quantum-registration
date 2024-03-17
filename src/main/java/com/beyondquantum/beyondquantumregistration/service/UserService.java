package com.beyondquantum.beyondquantumregistration.service;

import com.beyondquantum.beyondquantumregistration.entities.User;
import com.beyondquantum.beyondquantumregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUserToDatabase(User user) {
        userRepository.save(user);
    }
}
