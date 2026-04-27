package com.example.service;

import com.example.entity.Location;
import com.example.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location getLocationById(int locationID) {
        return locationRepository
                .findById(locationID)
                .orElse(null);
    }

    public Location getLocationByName(String name) {
        return locationRepository.findByName(name);
    }

    public boolean locationExists(int locationID) {
        return locationRepository.existsById(locationID);
    }
}