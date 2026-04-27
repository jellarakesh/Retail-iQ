package com.example.service;

import com.example.entity.Order;
import com.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {

        // Business rules
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("CREATED");

        return orderRepository.save(order);
    }

    public Order getOrderById(int orderID) {
        return orderRepository
                .findById(orderID)
                .orElse(null);
    }

    public List<Order> getOrdersByCustomer(int customerID) {
        return orderRepository.findByCustomerID(customerID);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public Order updateOrderStatus(int orderID, String status) {

        Order order = getOrderById(orderID);

        if (order == null) {
            return null;
        }

        order.setStatus(status);
        return orderRepository.save(order);
    }
}