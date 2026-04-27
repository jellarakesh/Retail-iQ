package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import com.example.dto.IntegrationEndpointDTO;
import com.example.dto.IntegrationEndpointResponseDTO;
import com.example.entity.IntegrationEndpoint;
import com.example.service.IntegrationEndpointService;

@RestController
@RequestMapping("/api")
public class IntegrationEndpointController {

    @Autowired
    private IntegrationEndpointService service;

    @PostMapping("/addIntegrationEndpoint")
    public ResponseEntity<IntegrationEndpointResponseDTO> addIntegrationEndpoint(
            @RequestBody IntegrationEndpointDTO dto) {

        IntegrationEndpoint endpoint = service.save(dto.getIntegrationEndpoint());

        IntegrationEndpointResponseDTO res = new IntegrationEndpointResponseDTO();
        res.setIntegrationEndpoint(endpoint);
        res.setStatusCode(201);
        res.setMessage("IntegrationEndpoint added successfully");

        return ResponseEntity.status(201).body(res);
    }

    @PostMapping("/updateIntegrationEndpoint")
    public ResponseEntity<IntegrationEndpointResponseDTO> updateIntegrationEndpoint(
            @RequestBody IntegrationEndpointDTO dto) {

        IntegrationEndpoint endpoint = service.update(dto.getIntegrationEndpoint());

        IntegrationEndpointResponseDTO res = new IntegrationEndpointResponseDTO();
        res.setIntegrationEndpoint(endpoint);
        res.setStatusCode(200);
        res.setMessage("IntegrationEndpoint updated successfully");

        return ResponseEntity.status(200).body(res);
    }

    @DeleteMapping("/deleteIntegrationEndpoint")
    public String deleteIntegrationEndpoint(
            @RequestBody IntegrationEndpoint endpoint) {

        service.delete(endpoint.getEndpointId());
        return "IntegrationEndpoint deleted successfully";
    }

    @GetMapping("/findIntegrationEndpoint/{id}")
    public IntegrationEndpoint findIntegrationEndpoint(
            @PathVariable Long id) {

        return service.getById(id);
    }

    @GetMapping("/fetchAllIntegrationEndpoints")
    public List<IntegrationEndpoint> fetchAllIntegrationEndpoints() {
        return service.getAll();
    }

    @GetMapping("/fetchIntegrationEndpointsWithPagination")
    public Page<IntegrationEndpoint> fetchIntegrationEndpointsWithPagination(
            @RequestParam int page,
            @RequestParam int size) {

        return service.getAllWithPagination(page, size);
    }
}