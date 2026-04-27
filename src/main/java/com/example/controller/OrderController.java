package com.example.controller;

import com.example.entity.Order;
import com.example.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/customer/{customerID}")
    public List<Order> getOrdersByCustomer(
            @PathVariable int customerID) {
        return orderService.getOrdersByCustomer(customerID);
    }

    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(
            @PathVariable String status) {
        return orderService.getOrdersByStatus(status);
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(
            @PathVariable int id,
            @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }
}