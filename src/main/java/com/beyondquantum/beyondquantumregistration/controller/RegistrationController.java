package com.beyondquantum.beyondquantumregistration.controller;

import com.beyondquantum.beyondquantumregistration.dto.UserDto;
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
    public String registrationForm(Model model) {
        model.addAttribute("user", new UserDto()); //sending empty user
        model.addAttribute("isEmailExists", false);
        model.addAttribute("isPhoneExists", false);
        model.addAttribute("isUsernameExists", false);

        return "registrationForm";
    }

    @PostMapping("/registration")
    public String onSubmit(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("result " + bindingResult);
            return "registrationForm";
        }

        //Checking if email exists in database
        User existingEmailUser = userService.getUserByEmail(userDto.getEmail());
        if (existingEmailUser != null && existingEmailUser.getEmail() != null && !existingEmailUser.getEmail().isEmpty()) {
            model.addAttribute("isEmailExists", true);
            return "registrationForm";
        }

        //Checking if phone exists in database
        User existingPhoneUser = userService.getUserByPhone(userDto.getPhone());
        if (existingPhoneUser != null && existingPhoneUser.getPhone() != null && !existingPhoneUser.getPhone().isEmpty()) {
            model.addAttribute("isPhoneExists", true);
            return "registrationForm";
        }

        //Checking if username exists in database
        User existingUsernameUser = userService.getUserByUsername(userDto.getUsername());
        if (existingUsernameUser != null && existingUsernameUser.getUsername() != null && !existingUsernameUser.getUsername().isEmpty()) {
            model.addAttribute("isUsernameExists", true);
            return "registrationForm";
        }

        userService.addUserToDatabase(userDto);
        return "success";
    }
}
