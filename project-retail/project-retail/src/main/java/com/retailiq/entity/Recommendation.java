package com.retailiq.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Recommendation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recId;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerProfile customer;

    @Column(columnDefinition="TEXT")
    private String skuList;

    private LocalDateTime generatedAt;

	public Long getRecId() {
		return recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public CustomerProfile getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerProfile customer) {
		this.customer = customer;
	}

	public String getSkuList() {
		return skuList;
	}

	public void setSkuList(String skuList) {
		this.skuList = skuList;
	}

	public LocalDateTime getGeneratedAt() {
		return generatedAt;
	}

	public void setGeneratedAt(LocalDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}

    // getters & setters
}
