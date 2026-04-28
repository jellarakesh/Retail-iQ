package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "sku", nullable = false, unique = true)
    private String sku;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private String attributes;

    public Product() {
        super();
    }

    public Product(Long productId, String sku, String name,
                   String category, String attributes) {
        this.productId = productId;
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.attributes = attributes;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Product [" +
                "productId=" + productId +
                ", sku=" + sku +
                ", name=" + name +
                ", category=" + category +
                ", attributes=" + attributes +
                "]";
    }
}