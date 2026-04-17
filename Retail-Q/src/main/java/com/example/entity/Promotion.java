package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private Long promotionId;

    @Column(nullable = false, length = 150)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PromotionType type;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String rules;

    @Column(nullable = false, length = 100)
    private String validity;

    public Promotion() {
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public String getName() {
        return name;
    }

    public PromotionType getType() {
        return type;
    }

    public String getRules() {
        return rules;
    }

    public String getValidity() {
        return validity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PromotionType type) {
        this.type = type;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}