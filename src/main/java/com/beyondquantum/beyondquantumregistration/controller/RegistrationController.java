package com.beyondquantum.beyondquantumregistration.controller;

import com.beyondquantum.beyondquantumregistration.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String registrationForm(){
        return "registrationForm";
    }

    @PostMapping("/success")
    public String onSubmit(){
        return "success";
    }
}
