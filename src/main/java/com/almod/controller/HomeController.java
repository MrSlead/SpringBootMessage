package com.almod.controller;
import com.almod.entity.User;
import com.almod.entity.UserLogin;
import com.almod.entity.user_service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepositiry;

    /*@GetMapping("/")
    public String home(@RequestParam(name = "name", required = false, defaultValue = "world") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }*/

    @GetMapping("/")
    public String home2(Map<String, Object> model){
        return "home";
    }

    @GetMapping("/main")
    public String index(@RequestParam(required = false, defaultValue = "") String firstname, Map<String, Object> model){
        Iterable<User> users = userRepositiry.findAll();

        if(!(firstname == null || firstname.isEmpty())){
            users = userRepositiry.findUserByFirstname(firstname);
            model.put("users", users);

            return "main";
        }
        model.put("users", users);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal UserLogin userLogin,
            @RequestParam String firstname,
            @RequestParam String secondname,
            Map<String, Object> model)
    {
        if(!(firstname.isEmpty() || firstname == null || secondname.isEmpty() || secondname == null)){
            userRepositiry.save(new User(firstname, secondname, userLogin));
        }

        Iterable<User> users = userRepositiry.findAll();
        model.put("users", users);

        return "main";
    }

}
