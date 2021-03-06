package com.ronalds.inventory_project.controller;

import com.ronalds.inventory_project.dao.RoleRepository;
import com.ronalds.inventory_project.entity.Client;
import com.ronalds.inventory_project.entity.Role;
import com.ronalds.inventory_project.entity.User;
import com.ronalds.inventory_project.service.ClientService;
import com.ronalds.inventory_project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    private ClientService clientService;

    private RoleRepository roleRepository;

    public UserController(UserService userService, ClientService clientService, RoleRepository roleRepository) {
        this.userService = userService;
        this.clientService = clientService;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/list")
    public String showUserListForClient(@RequestParam("client-id") int Id, Model model) {

        Client client = clientService.findById(Id);
        List<User> list = client.getUsers();

        model.addAttribute("userList", list);

        return "/user/list-users";
    }

    @PostMapping("/addUser")
    public String showFormForAdd(@RequestParam("client-id") int Id, Model model) {

        Client client = clientService.findById(Id);
        List<Client> list = clientService.findAll();
        User user = new User();
        user.setClient(client);

        List<Role> roles = roleRepository.findAll();

        model.addAttribute("roles", roles);
        model.addAttribute("clientList", list);
        model.addAttribute("user", user);
        model.addAttribute("client", client);

        return "/user/user-form";
    }


    @PostMapping("/save")
    public String saveClient(User user) {

        userService.saveUser(user);

        return "redirect:/clients/list";
    }
}
