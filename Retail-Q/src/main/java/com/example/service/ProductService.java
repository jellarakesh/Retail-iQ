package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    public String deleteProduct(Long productId) throws Exception {
        Product product = findProductById(productId);
        repository.delete(product);
        return "Product deleted successfully";
    }

    public Product findProductById(Long productId) throws Exception {
        return repository.findById(productId)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}