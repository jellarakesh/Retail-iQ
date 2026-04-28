package com.retailiq.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PriceList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceListId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String currency;
    private Double price;

    private LocalDateTime effectiveFrom;
    private LocalDateTime effectiveTo;
	public Long getPriceListId() {
		return priceListId;
	}
	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDateTime getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(LocalDateTime effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public LocalDateTime getEffectiveTo() {
		return effectiveTo;
	}
	public void setEffectiveTo(LocalDateTime effectiveTo) {
		this.effectiveTo = effectiveTo;
	}

    // getters & setters
}