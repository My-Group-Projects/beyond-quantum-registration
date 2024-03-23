package com.beyondquantum.beyondquantumregistration.service;

import com.beyondquantum.beyondquantumregistration.dto.UserDto;
import com.beyondquantum.beyondquantumregistration.entities.User;

public interface UserService {
    public void addUserToDatabase(UserDto userDto);
    public User getUserByEmail(String email);
    public User getUserByPhone(String phone);
    public User getUserByUsername(String username);
}
