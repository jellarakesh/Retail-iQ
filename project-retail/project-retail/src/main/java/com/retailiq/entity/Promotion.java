package com.retailiq.entity;

import jakarta.persistence.*;

@Entity
public class Promotion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotionId;

    private String name;

    @Enumerated(EnumType.STRING)
    private PromotionType type;

    @Column(columnDefinition="TEXT")
    private String rules;

    private String validity;

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PromotionType getType() {
		return type;
	}

	public void setType(PromotionType type) {
		this.type = type;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

    // getters & setters
}