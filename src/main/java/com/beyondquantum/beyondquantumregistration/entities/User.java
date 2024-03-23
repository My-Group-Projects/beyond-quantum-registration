package com.beyondquantum.beyondquantumregistration.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 6 digit user id
    @Column(unique = true)
    private String user_id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;

    // Username: Only lowercase letters, numbers, and underscores, cannot start with a number
    @Column(unique = true)
    private String username;

    // At least one letter, one digit, one capital letter, one small letter, and one special character
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String email, String phone, String username, String password) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public User() {
        super();
    }

    @PrePersist
    public void generateUserId() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        this.user_id = uuid.substring(0, 6);
    }
}
