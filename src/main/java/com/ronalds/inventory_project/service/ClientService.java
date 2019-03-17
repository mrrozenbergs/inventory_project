package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.Client;

import java.util.List;

public interface ClientService {

	List<Client> findAll();
	
	Client findById(int Id);
	
	void save(Client client);
	
	void deleteById(int Id);

}
