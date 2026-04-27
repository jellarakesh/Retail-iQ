package com.example.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FulfillmentItem")
public class FulfillmentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FulfillmentItemID")
    private int fulfillmentItemID;

    @Column(name = "InstructionID", nullable = false)
    private int instructionID;

    @Column(name = "SKU", nullable = false)
    private int sku;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    public FulfillmentItem() {}

    public FulfillmentItem(int instructionID, int sku, int quantity) {
        this.instructionID = instructionID;
        this.sku = sku;
        this.quantity = quantity;
    }

    public int getFulfillmentItemID() {
        return fulfillmentItemID;
    }

    public int getInstructionID() {
        return instructionID;
    }

    public void setInstructionID(int instructionID) {
        this.instructionID = instructionID;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FulfillmentItem that)) return false;
        return fulfillmentItemID == that.fulfillmentItemID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fulfillmentItemID);
    }
}
