package com.example.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="order")
public class Order {

    @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderID;

    @Column
    int customerID;

    @Column
    String channel;

    @Column
    Date orderDate;

    @Column
    String status;

    @Column
    double totalAmount;

    public Order(int orderID, int customerID, String channel, Date orderDate, String status, double totalAmount) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.channel = channel;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public Order() {

    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", channel='" + channel + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && customerID == order.customerID && Double.compare(totalAmount, order.totalAmount) == 0 && Objects.equals(channel, order.channel) && Objects.equals(orderDate, order.orderDate) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, customerID, channel, orderDate, status, totalAmount);
    }
}
