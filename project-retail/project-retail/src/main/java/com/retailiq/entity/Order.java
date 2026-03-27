package com.retailiq.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerProfile customer;

    @Enumerated(EnumType.STRING)
    private OrderChannel channel;

    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<FulfillmentInstruction> instructions = new ArrayList<>();

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public CustomerProfile getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerProfile customer) {
		this.customer = customer;
	}

	public OrderChannel getChannel() {
		return channel;
	}

	public void setChannel(OrderChannel channel) {
		this.channel = channel;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<FulfillmentInstruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<FulfillmentInstruction> instructions) {
		this.instructions = instructions;
	}

    // getters & setters
}
