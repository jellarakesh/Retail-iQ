package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.ProductDTO;
import com.example.dto.ProductResponseDTO;
import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public ResponseEntity<ProductResponseDTO> addProduct(
            @RequestBody ProductDTO productDTO) {

        Product saved = service.addProduct(productDTO.getProduct());

        ProductResponseDTO response = new ProductResponseDTO();
        response.setProduct(saved);
        response.setStatusCode(201);
        response.setMessage("Product added successfully");

        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/update")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @RequestBody ProductDTO productDTO) {

        Product updated = service.updateProduct(productDTO.getProduct());

        ProductResponseDTO response = new ProductResponseDTO();
        response.setProduct(updated);
        response.setStatusCode(200);
        response.setMessage("Product updated successfully");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) throws Exception {
        return service.deleteProduct(id);
    }

    @GetMapping("/find/{id}")
    public Product findProduct(@PathVariable Long id) throws Exception {
        return service.findProductById(id);
    }

    @GetMapping("/fetchAll")
    public List<Product> fetchAllProducts() {
        return service.getAllProducts();
    }
}