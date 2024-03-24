package com.beyondquantum.beyondquantumregistration.service;

import com.beyondquantum.beyondquantumregistration.dto.UserDto;
import com.beyondquantum.beyondquantumregistration.entities.User;
import com.beyondquantum.beyondquantumregistration.repository.UserRepository;
import com.beyondquantum.beyondquantumregistration.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUserToDatabase(UserDto userDto) {
        User user = new User();
        user.setName(EncryptionUtil.encrypt(userDto.getName()));
        user.setUsername(EncryptionUtil.encrypt(userDto.getUsername()));
        user.setEmail(EncryptionUtil.encrypt(userDto.getEmail()));
        user.setPhone(EncryptionUtil.encrypt(userDto.getPhone()));
        user.setPassword(passwordEncoder.encode(EncryptionUtil.encrypt(userDto.getPassword())));

        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(EncryptionUtil.encrypt(email));
    }

    @Override
    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(EncryptionUtil.encrypt(phone));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(EncryptionUtil.encrypt(username));
    }
}
