package com.example.service;

import com.example.dto.LocationRequestDTO;
import com.example.dto.LocationResponseDTO;
import com.example.entity.Location;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.LocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public LocationResponseDTO create(LocationRequestDTO dto) {
        Location location = mapToEntity(dto);
        Location saved = locationRepository.save(location);
        return mapToResponse(saved);
    }

    public LocationResponseDTO getById(int id) {
        Location location = locationRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Location not found with id " + id));
        return mapToResponse(location);
    }


    public LocationResponseDTO getByName(String name) {
        Location location = locationRepository.findByName(name);
        if (location == null) {
            throw new ResourceNotFoundException(
                    "Location not found with name " + name);
        }
        return mapToResponse(location);
    }


    public Page<LocationResponseDTO> getAll(int page, int size) {
        return locationRepository.findAll(PageRequest.of(page, size))
                .map(this::mapToResponse);
    }


    public LocationResponseDTO update(int id, LocationRequestDTO dto) {

        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found with id " + id));

        location.setName(dto.getName());
        location.setType(dto.getType());
        location.setRegion(dto.getRegion());

        return mapToResponse(locationRepository.save(location));
    }

    public void delete(int id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Location not found with id " + id));
        locationRepository.delete(location);
    }



    private Location mapToEntity(LocationRequestDTO dto) {
        Location location = new Location();
        location.setName(dto.getName());
        location.setType(dto.getType());
        location.setRegion(dto.getRegion());
        return location;
    }


    private LocationResponseDTO mapToResponse(Location location) {
        LocationResponseDTO dto = new LocationResponseDTO();
        dto.setLocationID(location.getLocationID());
        dto.setName(location.getName());
        dto.setType(location.getType());
        dto.setRegion(location.getRegion());
        return dto;
    }



}