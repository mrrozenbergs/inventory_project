package com.ronalds.inventory_project.dao;

import com.ronalds.inventory_project.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	public List<Client> findAllByOrderByCompanyName();
	
}

