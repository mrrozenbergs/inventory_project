package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.Client;

import java.util.List;

public interface ClientService {

	public List<Client> findAll();
	
	public Client findById(int Id);
	
	public void save(Client client);
	
	public void deleteById(int Id);

}
