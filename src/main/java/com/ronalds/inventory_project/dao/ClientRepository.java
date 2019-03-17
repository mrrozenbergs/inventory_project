package com.ronalds.inventory_project.dao;

import com.ronalds.inventory_project.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	List<Client> findAllByOrderById();
}