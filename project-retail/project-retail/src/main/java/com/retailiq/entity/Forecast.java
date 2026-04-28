package com.retailiq.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Forecast {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forecastId;

    private String sku;

    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    private String period;
    private Integer forecastQty;
    private LocalDateTime generatedAt;
	public Long getForecastId() {
		return forecastId;
	}
	public void setForecastId(Long forecastId) {
		this.forecastId = forecastId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Integer getForecastQty() {
		return forecastQty;
	}
	public void setForecastQty(Integer forecastQty) {
		this.forecastQty = forecastQty;
	}
	public LocalDateTime getGeneratedAt() {
		return generatedAt;
	}
	public void setGeneratedAt(LocalDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}

    // getters & setters
}
