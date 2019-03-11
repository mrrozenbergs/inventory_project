package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.dao.ClientRepository;
import com.ronalds.inventory_project.dao.RoleRepository;
import com.ronalds.inventory_project.entity.Client;
import com.ronalds.inventory_project.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAllByOrderById();
    }

    @Override
    public Client findById(int Id) {
        Optional<Client> result = clientRepository.findById(Id);

        Client client = null;

        if (result.isPresent()) {
            client = result.get();
        } else {
            throw new RuntimeException("Did not find Client id - " + Id);
        }

        return client;
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteById(int Id) {
        clientRepository.deleteById(Id);
    }


}






