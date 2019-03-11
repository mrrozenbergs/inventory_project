package com.ronalds.inventory_project.controller;

import com.ronalds.inventory_project.entity.Product;
import com.ronalds.inventory_project.entity.User;
import com.ronalds.inventory_project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addUser")
    public String showFormForAdd(Model model) {

        User user = new User();

        model.addAttribute("user", user);

        return "/user/user-form";
    }


    @PostMapping("/save")
    public String saveClient(@ModelAttribute("product") User user) {

        userService.saveUser(user);

        return "redirect:/products/list";
    }
}
