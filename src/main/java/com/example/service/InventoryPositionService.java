package com.example.service;


import com.example.dto.InventoryPositionRequestDTO;
import com.example.dto.InventoryPositionResponseDTO;
import com.example.entity.InventoryPosition;
import com.example.repository.InventoryPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;


@Service
public class InventoryPositionService {
    @Autowired
    private  final InventoryPositionRepository repository;

    public InventoryPositionService(InventoryPositionRepository repository) {

        this.repository = repository;
    }
    public InventoryPositionResponseDTO create(InventoryPositionResponseDTO dto){
        InventoryPosition saved = repository.save(mapToEntity(dto));
        return mapToResponse(saved);
    }

    public InventoryPositionResponseDTO getById(int id){
        InventoryPosition entity = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Inventory position not found with id"+id));
        return mapToResponse(entity);

    }


    public Page<InventoryPositionResponseDTO> getAll(
            int page, int size) {

        return repository.findAll(PageRequest.of(page, size))
                .map(this::mapToResponse);
    }


    public InventoryPositionResponseDTO update(int id, InventoryPositionRequestDTO dto) {

        InventoryPosition entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "InventoryPosition not found with id " + id));

        entity.setLocationID(dto.getLocationID());
        entity.setSku(dto.getSku());
        entity.setQuantityOnHand(dto.getQuantityOnHand());
        entity.setQuantityReserved(dto.getQuantityReserved());
        entity.setSafetyStock(dto.getSafetyStock());

        return mapToResponse(repository.save(entity));
    }


    public void delete(int id) {
        InventoryPosition entity = repository.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException(
                            "InventoryPosition not found with id " + id);
                });

        repository.delete(entity);
    }


    private InventoryPosition mapToEntity(InventoryPositionRequestDTO dto) {

        InventoryPosition entity = new InventoryPosition();
        entity.setLocationID(dto.getLocationID());
        entity.setSku(dto.getSku());
        entity.setQuantityOnHand(dto.getQuantityOnHand());
        entity.setQuantityReserved(dto.getQuantityReserved());
        entity.setSafetyStock(dto.getSafetyStock());
        return entity;
    }


    private InventoryPositionResponseDTO mapToResponse(InventoryPosition entity) {

        InventoryPositionResponseDTO dto = new InventoryPositionResponseDTO();
        dto.setLocationID(entity.getLocationID());
        dto.setSku(entity.getSku());
        dto.setQuantityOnHand(entity.getQuantityOnHand());
        dto.setQuantityReserved(entity.getQuantityReserved());
        dto.setSafetyStock(entity.getSafetyStock());
        return dto;
    }

}