package com.example.apiCall.controllers;

import com.example.apiCall.model.Product;
import com.example.apiCall.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/product")
@RestController
@Slf4j
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Get All Available Products
    @GetMapping(path="{pageNo}/{pageSize}")
    public List<Product> getAllProducts(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        return productService.getAllProduct(pageNo, pageSize);
    }

    //Get a Product by ID
    @GetMapping(path="{productid}")
    public Optional<Product> getProductById(@PathVariable("productid") String productid){
        return productService.getProductById(productid);
    }

    //Add a new Product
    @PostMapping(path="create")
    public void createNewProduct(@RequestBody Product newProduct){
        productService.createNewProduct(newProduct);
    }

    //Delete a Product by ID
    @DeleteMapping(path="delete/{productid}")
    public void deleteProductById(@PathVariable("productid") String productid){
        productService.deleteProductById(productid);
    }
    //Update a Product's Information by ID
    @PutMapping(path="update/{productid}")
    public void updateProductById(@RequestBody Product product, @PathVariable("productid") String productid){
        productService.updateProductById(productid, product);
    }
}