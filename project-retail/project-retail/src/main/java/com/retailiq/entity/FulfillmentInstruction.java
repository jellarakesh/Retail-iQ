package com.retailiq.entity;

import jakarta.persistence.*;

@Entity
public class FulfillmentInstruction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructionId;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="source_location_id")
    private Location sourceLocation;

    private String destination;

    @Column(columnDefinition="TEXT")
    private String items;

    private String status;

	public Long getInstructionId() {
		return instructionId;
	}

	public void setInstructionId(Long instructionId) {
		this.instructionId = instructionId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Location getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(Location sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    // getters & setters
}