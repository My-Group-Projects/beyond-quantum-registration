package com.beyondquantum.beyondquantumregistration.controller;

import com.beyondquantum.beyondquantumregistration.entities.User;
import com.beyondquantum.beyondquantumregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("user", new User()); //sending empty user
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String onSubmit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("result " + bindingResult);
            return "registrationForm";
        }
        userService.addUserToDatabase(user);
        return "success";
    }
}
