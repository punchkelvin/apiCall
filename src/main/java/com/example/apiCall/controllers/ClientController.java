package com.example.apiCall.controllers;

import com.example.apiCall.model.Client;
import com.example.apiCall.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/client")
@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //Get All Clients
    @GetMapping(path="{pageNo}/{pageSize}")
    public List<Client> getAllClients(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        return clientService.getAllClient(pageNo, pageSize);
    }

    //Get a Client by ID
    @GetMapping(path="{clientId}")
    public Optional<Client> getClientById(@PathVariable("clientId") String clientId){
        return clientService.getClientById(clientId);
    }

    //Add a new Client
    @PostMapping(path="create")
    public void createNewClient(@RequestBody Client newClient){
        clientService.createNewClient(newClient);
    }

    //Delete a Product by ID
    @DeleteMapping(path="delete/{clientId}")
    public void deleteClientById(@PathVariable("clientId") String clientId){
        clientService.deleteClientByID(clientId);
    }

    @PutMapping(path="update/{clientId}")
    public void updateProductById(@RequestBody Client client, @PathVariable("clientId") String clientId){
        clientService.updateClientByID(clientId, client);
    }

}
