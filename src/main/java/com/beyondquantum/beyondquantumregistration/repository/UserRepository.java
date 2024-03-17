package com.beyondquantum.beyondquantumregistration.repository;

import com.beyondquantum.beyondquantumregistration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
