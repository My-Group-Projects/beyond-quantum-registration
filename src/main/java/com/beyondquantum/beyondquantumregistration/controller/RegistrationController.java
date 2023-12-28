package com.beyondquantum.beyondquantumregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("name", "Abhay Bhandari");
        return "registrationForm";
    }
}
