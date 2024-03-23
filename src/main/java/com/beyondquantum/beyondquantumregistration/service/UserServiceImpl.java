package com.beyondquantum.beyondquantumregistration.service;

import com.beyondquantum.beyondquantumregistration.dto.UserDto;
import com.beyondquantum.beyondquantumregistration.entities.User;
import com.beyondquantum.beyondquantumregistration.repository.UserRepository;
import com.beyondquantum.beyondquantumregistration.util.EncryptionDecryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUserToDatabase(UserDto userDto) {
        User user = new User();
        user.setName(EncryptionDecryptionUtil.encrypt(userDto.getName()));
        user.setUsername(EncryptionDecryptionUtil.encrypt(userDto.getUsername()));
        user.setEmail(EncryptionDecryptionUtil.encrypt(userDto.getEmail()));
        user.setPhone(EncryptionDecryptionUtil.encrypt(userDto.getPhone()));
        user.setPassword(EncryptionDecryptionUtil.encrypt(userDto.getPassword()));

        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(EncryptionDecryptionUtil.encrypt(email));
    }

    @Override
    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(EncryptionDecryptionUtil.encrypt(phone));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(EncryptionDecryptionUtil.encrypt(username));
    }
}
