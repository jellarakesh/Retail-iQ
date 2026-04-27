package com.example.controller;

import com.example.dto.LocationRequestDTO;
import com.example.dto.LocationResponseDTO;
import com.example.entity.Location;
import com.example.service.LocationService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

   private final LocationService locationService;


    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @PostMapping
    public LocationResponseDTO create(@RequestBody LocationRequestDTO dto) {
        return locationService.create(dto);
    }

    @GetMapping("/{id}")
    public LocationResponseDTO getById(
            @PathVariable int id) {
        return locationService.getById(id);
    }


    @GetMapping("/by-name")
    public LocationResponseDTO getByName(
            @RequestParam String name) {
        return locationService.getByName(name);
    }


    @GetMapping
    public Page<LocationResponseDTO> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return locationService.getAll(page, size);
    }


    @PutMapping("/{id}")
    public LocationResponseDTO update(
            @PathVariable int id,
            @RequestBody LocationRequestDTO dto) {
        return locationService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        locationService.delete(id);
    }



}