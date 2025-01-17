package com.almod.controller;

import com.almod.entity.Role;
import com.almod.entity.UserLogin;
import com.almod.entity.user_service.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserLoginRepository userLoginRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserLogin user, Map<String, Object> model) {
        UserLogin userFromDb = userLoginRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userLoginRepository.save(user);

        return "redirect:/login";
    }
}