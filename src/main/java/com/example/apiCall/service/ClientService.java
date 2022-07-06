package com.example.apiCall.service;

import com.example.apiCall.model.Client;
import com.example.apiCall.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClient(int pageNo, int pageSize){
        log.info("Get List of all clients");
        Pageable paging = PageRequest.of(pageNo,pageSize);
        Page<Client> pagedResult = clientRepository.findAll(paging);
        return pagedResult.toList();
    }

    public Optional<Client> getClientById(String id){
        log.info("Get Information about client with ID");
        return clientRepository.findById(Long.parseLong(id));
    }

    public void createNewClient(Client client){
        log.info("Add New Client");
        clientRepository.save(client);
    }

    public void deleteClientByID(String id){
        log.info("Delete Product with ID");
        clientRepository.deleteById(Long.parseLong(id));
    }

    public void updateClientByID(String id, Client client){
        log.info("Update Client's Information with ID");
        clientRepository.save(client);
    }


}
