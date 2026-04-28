package com.retailiq.entity;

import jakarta.persistence.*;

@Entity
public class ReplenishmentOrder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replenishmentId;

    private String sku;

    @ManyToOne @JoinColumn(name="from_location_id")
    private Location fromLocation;

    @ManyToOne @JoinColumn(name="to_location_id")
    private Location toLocation;

    private Integer quantity;
    private String status;
	public Long getReplenishmentId() {
		return replenishmentId;
	}
	public void setReplenishmentId(Long replenishmentId) {
		this.replenishmentId = replenishmentId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Location getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(Location fromLocation) {
		this.fromLocation = fromLocation;
	}
	public Location getToLocation() {
		return toLocation;
	}
	public void setToLocation(Location toLocation) {
		this.toLocation = toLocation;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    // getters & setters
}
