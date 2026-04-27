package com.example.service;

import com.example.entity.InventoryPosition;
import com.example.repository.InventoryPositionRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryPositionService {

    private final InventoryPositionRepository inventoryRepository;

    public InventoryPositionService(
            InventoryPositionRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryPosition saveInventory(
            InventoryPosition inventoryPosition) {
        return inventoryRepository.save(inventoryPosition);
    }

    public InventoryPosition getInventoryBySkuAndLocation(
            int sku, int locationID) {
        return inventoryRepository
                .findBySkuAndLocationID(sku, locationID);
    }

    public int getAvailableQuantity(int sku, int locationID) {

        InventoryPosition position =
                inventoryRepository
                        .findBySkuAndLocationID(sku, locationID);

        if (position == null) {
            return 0;
        }

        return position.getQuantityOnHand()
                - position.getQuantityReserved()
                - position.getSafetyStock();
    }
}