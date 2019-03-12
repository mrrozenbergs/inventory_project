package com.ronalds.inventory_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "/login";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/notEnoughProducts")
    public String notEnoughProducts() {
        return "/not-enough-products";
    }

    @GetMapping("/error")
    public String error() {
        return "/error/403";
    }

}
