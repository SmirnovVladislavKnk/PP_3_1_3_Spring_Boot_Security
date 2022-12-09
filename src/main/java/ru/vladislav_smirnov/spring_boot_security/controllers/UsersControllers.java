package ru.vladislav_smirnov.spring_boot_security.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vladislav_smirnov.spring_boot_security.model.User;
import ru.vladislav_smirnov.spring_boot_security.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UsersControllers {

    private final UserService userService;

    @Autowired
    public UsersControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUser(Principal principal, ModelMap modelMap) {
        User user = userService.findByEmail(principal.getName());
        modelMap.addAttribute("user", user);
        return "/user/index";
    }
}
