package com.example.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class CustomerProfile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;
    private String email;
    private String loyaltyTier;

    @Column(columnDefinition="TEXT")
    private String preferences;

    @OneToMany(mappedBy="customer")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy="customer")
    private List<Recommendation> recommendations = new ArrayList<>();

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoyaltyTier() {
		return loyaltyTier;
	}

	public void setLoyaltyTier(String loyaltyTier) {
		this.loyaltyTier = loyaltyTier;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Recommendation> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}

    // getters & setters
}