package com.example.apiCall.controllers;
import com.example.apiCall.model.Client;
import com.example.apiCall.model.Product;
import com.example.apiCall.service.ClientService;
import com.example.apiCall.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RequestMapping("api/v1/purchase")
@RestController
public class SalesController {
    private final ProductService productService;
    private final ClientService clientService;

    public SalesController(ProductService productService, ClientService clientService) {
        this.productService = productService;
        this.clientService = clientService;
    }

    //Get a Client balance by ID
    @PutMapping(path="/{clientId}/{productId}")
    public int purchaseItem(@PathVariable("clientId") String clientId, @PathVariable("productId") String productId){
        int clientBalance = 0;
        int productPrice = 0;
        Optional<Client> retrievedClient = clientService.getClientById(clientId);
        Optional<Product> retrievedProduct = productService.getProductById(productId);
        if(retrievedClient.isPresent() && retrievedProduct.isPresent()){
            Client existingClient = retrievedClient.get();
            Product existingProduct = retrievedProduct.get();
            productPrice = existingProduct.getProduct_price();
            clientBalance = existingClient.getClient_balance();
            if(productPrice <= clientBalance){
                clientBalance = clientBalance - productPrice;
                existingClient.setClient_balance(clientBalance);
                clientService.updateClientByID(clientId, existingClient);
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Not enough balance");
            }
        }
        return  clientBalance;
    }
}

