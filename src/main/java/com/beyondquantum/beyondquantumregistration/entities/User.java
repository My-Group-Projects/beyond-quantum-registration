package com.beyondquantum.beyondquantumregistration.entities;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class User {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$", message = "Invalid Email Address")
    private String email;
    @Pattern(regexp = "[0-9]{10}", message = "Invalid Phone Number")
    @NotBlank(message = "Phone cannot be blank")
    private String phone;

    // Username: Only lowercase letters, numbers, and underscores, cannot start with a number
    @Pattern(regexp = "^(?=(?:[^a-z]*[a-z]){3})[a-z\\d_]{5,}$", message = "Username must be at least 5 characters long, may contain underscores, may contain numbers, only small letters are allowed, and should have at least 3 letters.")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    // At least one letter, one digit, one capital letter, one small letter, and one special character
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Your password must be atleast 8 characters long, contain atleast one Capital, Small Letter, Special Character and a Number.")
    @NotBlank(message = "Please set a password")
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

    public User(){
        super();
    }
}
