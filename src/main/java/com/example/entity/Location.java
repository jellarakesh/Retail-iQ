package com.example.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="Location")
public class Location {

    @Id
    int locationID;

    @Column
    String name;

    @Column
    String type;

    @Column
    String region;

    public Location(int locationID, String name, String type, String region) {
        this.locationID = locationID;
        this.name = name;
        this.type = type;
        this.region = region;
    }

    public Location() {
        super();
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationID == location.locationID && Objects.equals(name, location.name) && Objects.equals(type, location.type) && Objects.equals(region, location.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationID, name, type, region);
    }
}
