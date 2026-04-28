package com.retailiq.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String sku;
    private String name;
    private String category;

    @Column(columnDefinition="TEXT")
    private String attributes;

    @OneToMany(mappedBy = "product")
    private List<PriceList> priceLists = new ArrayList<>();

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

	public List<PriceList> getPriceLists() {
		return priceLists;
	}

	public void setPriceLists(List<PriceList> priceLists) {
		this.priceLists = priceLists;
	}

    // getters & setters
}
