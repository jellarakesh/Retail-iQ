package com.example.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Location {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private String name;

    private String type;

    private String region;

    @OneToMany(mappedBy = "location")
    private List<InventoryPosition> inventory = new ArrayList<>();

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<InventoryPosition> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryPosition> inventory) {
		this.inventory = inventory;
	}

    // getters & setters
}
