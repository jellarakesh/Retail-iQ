package com.example.controller;

import com.example.entity.InventoryPosition;
import com.example.service.InventoryPositionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryPositionController {

    private final InventoryPositionService inventoryService;

    public InventoryPositionController(
            InventoryPositionService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public InventoryPosition saveInventory(
            @RequestBody InventoryPosition inventoryPosition) {
        return inventoryService.saveInventory(inventoryPosition);
    }

    @GetMapping
    public InventoryPosition getInventory(
            @RequestParam int sku,
            @RequestParam int locationID) {
        return inventoryService
                .getInventoryBySkuAndLocation(sku, locationID);
    }

    @GetMapping("/available")
    public int getAvailableInventory(
            @RequestParam int sku,
            @RequestParam int locationID) {
        return inventoryService
                .getAvailableQuantity(sku, locationID);
    }
}
