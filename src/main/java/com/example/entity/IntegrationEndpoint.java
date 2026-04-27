package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "integration_endpoint")
public class IntegrationEndpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endpointId;

    @Column(nullable = false, unique = true)
    private String name;
    // Example: SAP_ERP, Oracle_POS, FedEx_API

    // POS / ERP / WMS / CARRIER
    @Column(nullable = false)
    private String type;

    @Column(nullable = false, length = 1000)
    private String config;

    @Column(nullable = false)
    private boolean active;

    public IntegrationEndpoint() {
        this.active = true;
    }

    // Getters and Setters

    public Long getEndpointId() {
        return endpointId;
    }

    public void setEndpointId(Long endpointId) {
        this.endpointId = endpointId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "IntegrationEndpoint{" +
                "endpointId=" + endpointId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", config='" + config + '\'' +
                ", active=" + active +
                '}';
    }
}