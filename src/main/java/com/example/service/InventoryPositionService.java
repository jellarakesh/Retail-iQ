package com.example.service;

import com.example.dto.InventoryPositionRequestDTO;
import com.example.dto.InventoryPositionResponseDTO;
import com.example.entity.InventoryPosition;
import com.example.repository.InventoryPositionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class InventoryPositionService {

    private final InventoryPositionRepository repository;

    public InventoryPositionService(InventoryPositionRepository repository) {
        this.repository = repository;
    }

    // ✅ CREATE
    public InventoryPositionResponseDTO create(InventoryPositionRequestDTO dto) {

        InventoryPosition inventory = new InventoryPosition(
                dto.getLocationID(),
                dto.getSku(),
                dto.getQuantityOnHand(),
                dto.getQuantityReserved(),
                dto.getSafetyStock()
        );

        InventoryPosition saved = repository.save(inventory);
        return toResponseDTO(saved);
    }

    // ✅ GET BY ID
    public InventoryPositionResponseDTO getById(int id) {

        InventoryPosition inventory = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        return toResponseDTO(inventory);
    }

    // ✅ GET ALL
    public Page<InventoryPositionResponseDTO> getAll(int page, int size) {

        return repository.findAll(PageRequest.of(page, size))
                .map(this::toResponseDTO);
    }

    // ✅ UPDATE (FIXED: NO new entity, ID preserved)
    public InventoryPositionResponseDTO update(int id, InventoryPositionRequestDTO dto) {

        InventoryPosition inventory = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        inventory.setLocationID(dto.getLocationID());
        inventory.setSku(dto.getSku());
        inventory.setQuantityOnHand(dto.getQuantityOnHand());
        inventory.setQuantityReserved(dto.getQuantityReserved());
        inventory.setSafetyStock(dto.getSafetyStock());

        InventoryPosition saved = repository.save(inventory);
        return toResponseDTO(saved);
    }

    // ✅ DELETE (FIXED: deletes by InventoryID)
    public void delete(int id) {
        repository.deleteById(id);
    }

    // ✅ INTERNAL DTO MAPPING (NO mapper class)
    private InventoryPositionResponseDTO toResponseDTO(InventoryPosition inventory) {

        InventoryPositionResponseDTO dto = new InventoryPositionResponseDTO();
        dto.setInventoryId(inventory.getInventoryID());
        dto.setLocationID(inventory.getLocationID());
        dto.setSku(inventory.getSku());
        dto.setQuantityOnHand(inventory.getQuantityOnHand());
        dto.setQuantityReserved(inventory.getQuantityReserved());
        dto.setSafetyStock(inventory.getSafetyStock());
        return dto;
    }
}