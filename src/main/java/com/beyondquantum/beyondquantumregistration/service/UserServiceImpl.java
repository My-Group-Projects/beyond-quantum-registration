package com.beyondquantum.beyondquantumregistration.service;

import com.beyondquantum.beyondquantumregistration.dto.UserDto;
import com.beyondquantum.beyondquantumregistration.entities.User;
import com.beyondquantum.beyondquantumregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUserToDatabase(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserByPhone(String phone) {
        return  userRepository.findByPhone(phone);
    }

    @Override
    public User getUserByUsername(String username) {
        return  userRepository.findByUsername(username);
    }
}
