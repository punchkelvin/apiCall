package com.example.apiCall.service;

import com.example.apiCall.model.Product;
import com.example.apiCall.repository.ProductRepository;
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
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct(int pageNo, int pageSize) {
        log.info("Get List of all products with Custom Pagination");
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> pagedResult = productRepository.findAll(paging);
        return pagedResult.toList();
    }

    public Optional<Product> getProductById(String id){
        log.info("Get Information about product with ID");
        return productRepository.findById(Long.parseLong(id));
    }

    public  void createNewProduct(Product product){
        log.info("Add New Product");
        productRepository.save(product);
    }

    public void deleteProductById(String id){
        log.info("Delete Product with ID");
        productRepository.deleteById(Long.parseLong(id));
    }

    public void updateProductById(String id, Product product){
        log.info("Update Product's Information with ID");
        productRepository.save(product);
    }
}