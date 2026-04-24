package com.example.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="InventoryPosition")
public class InventoryPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryID;

    @Column
    private int locationID;

    @Column
    private int sku;

    @Column
    private int quantityOnHand;

    @Column
    private int quantityReserved;

    @Column
    private int safetyStock;

    public InventoryPosition(int locationID, int sku, int quantityOnHand, int quantityReserved,int safetyStock){
        super();
        this.locationID = locationID;
        this.sku = sku;
        this.quantityOnHand = quantityOnHand;
        this.quantityReserved = quantityReserved;
        this.safetyStock = safetyStock;

    }
public  InventoryPosition()
{
        super();
}

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public int getQuantityReserved() {
        return quantityReserved;
    }

    public void setQuantityReserved(int qualityReserved) {
        this.quantityReserved = qualityReserved;
    }

    public int getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(int safetyStock) {
        this.safetyStock = safetyStock;
    }

    @Override
    public String toString() {
        return "InventoryPosition{" +
                "inventoryID=" + inventoryID +
                ", locationID=" + locationID +
                ", sku=" + sku +
                ", quantityOnHand=" + quantityOnHand +
                ", quantityReserved=" + quantityReserved +
                ", safetyStock=" + safetyStock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InventoryPosition that = (InventoryPosition) o;
        return inventoryID == that.inventoryID && locationID == that.locationID && sku == that.sku && quantityOnHand == that.quantityOnHand && quantityReserved == that.quantityReserved && safetyStock == that.safetyStock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryID, locationID, sku, quantityOnHand, quantityReserved, safetyStock);
    }
}
