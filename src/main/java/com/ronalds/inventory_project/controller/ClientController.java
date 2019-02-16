package com.ronalds.inventory_project.controller;

import com.ronalds.inventory_project.entity.Client;
import com.ronalds.inventory_project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

	private ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}


	@GetMapping("/list")
	public String listClients(Model model) {

		List<Client> clients = clientService.findAll();

		model.addAttribute("client", clients);
		
		return "/clients/list-clients";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Client client = new Client();
		
		model.addAttribute("client", client);
		
		return "/clients/client-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("clientId") int Id,
									Model model) {
		
		Client client = clientService.findById(Id);
		
		model.addAttribute("client", client);

		return "/clients/client-form";
	}
	
	
	@PostMapping("/save")
	public String saveClient(@ModelAttribute("client") Client client) {
		
		clientService.save(client);
		
		return "redirect:/clients/list";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("clientId") int Id) {
		
		clientService.deleteById(Id);
		
		return "redirect:/clients/list";
	}
}


















