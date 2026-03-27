package com.retailiq.entity;

import jakarta.persistence.*;

@Entity
public class InventoryPosition {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private String sku;
    private Integer quantityOnHand;
    private Integer quantityReserved;
    private Integer safetyStock;
	public Long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getQuantityOnHand() {
		return quantityOnHand;
	}
	public void setQuantityOnHand(Integer quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
	public Integer getQuantityReserved() {
		return quantityReserved;
	}
	public void setQuantityReserved(Integer quantityReserved) {
		this.quantityReserved = quantityReserved;
	}
	public Integer getSafetyStock() {
		return safetyStock;
	}
	public void setSafetyStock(Integer safetyStock) {
		this.safetyStock = safetyStock;
	}

    // getters & setters
}
