package com.example.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="fulfillmentInstruction")
public class FulfillmentInstruction {

    @Id
    private int instructionID;

    @Column
    private int orderID;

    @Column
    private String sourceLocationID;

    @Column
    private String destination;

    @OneToMany
    @JoinColumn(name = "InstructionID")
    private List<FulfillmentInstruction> items;

    @Column
    private  String status;

    public FulfillmentInstruction(int instructionID, int orderID, String sourceLocationID, String destination, List<FulfillmentInstruction> items, String status) {
        this.instructionID = instructionID;
        this.orderID = orderID;
        this.sourceLocationID = sourceLocationID;
        this.destination = destination;
        this.items = items;
        this.status = status;
    }

    public FulfillmentInstruction() {
    }

    public int getInstructionID() {
        return instructionID;
    }

    public void setInstructionID(int instructionID) {
        this.instructionID = instructionID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getSourceLocationID() {
        return sourceLocationID;
    }

    public void setSourceLocationID(String sourceLocationID) {
        this.sourceLocationID = sourceLocationID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<FulfillmentInstruction> getItems() {
        return items;
    }

    public void setItems(List<FulfillmentInstruction> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FulfillmentInstruction{" +
                "instructionID=" + instructionID +
                ", orderID=" + orderID +
                ", sourceLocationID='" + sourceLocationID + '\'' +
                ", destination='" + destination + '\'' +
                ", items=" + items +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FulfillmentInstruction that = (FulfillmentInstruction) o;
        return instructionID == that.instructionID && orderID == that.orderID && Objects.equals(sourceLocationID, that.sourceLocationID) && Objects.equals(destination, that.destination) && Objects.equals(items, that.items) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionID, orderID, sourceLocationID, destination, items, status);
    }
}
