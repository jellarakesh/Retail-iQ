package com.retailiq.entity;

import jakarta.persistence.*;

@Entity
public class IntegrationEndpoint {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endpointId;

    private String name;

    @Enumerated(EnumType.STRING)
    private IntegrationType type;

    @Column(columnDefinition="TEXT")
    private String config;

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

	public IntegrationType getType() {
		return type;
	}

	public void setType(IntegrationType type) {
		this.type = type;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

    // getters & setters
}