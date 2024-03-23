package com.beyondquantum.beyondquantumregistration.repository;

import com.beyondquantum.beyondquantumregistration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByPhone(String phone);
    User findByUsername(String username);
}
