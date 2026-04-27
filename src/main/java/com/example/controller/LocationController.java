package com.example.controller;

import com.example.entity.Location;
import com.example.service.LocationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public Location saveLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable int id) {
        return locationService.getLocationById(id);
    }

    @GetMapping("/by-name")
    public Location getLocationByName(@RequestParam String name) {
        return locationService.getLocationByName(name);
    }
}