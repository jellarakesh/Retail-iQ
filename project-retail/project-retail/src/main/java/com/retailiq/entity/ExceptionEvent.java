package com.retailiq.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ExceptionEvent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exceptionId;

    private String type;
    private String referenceId;

    private LocalDate detectedDate;
    private String severity;
    private String status;
	public Long getExceptionId() {
		return exceptionId;
	}
	public void setExceptionId(Long exceptionId) {
		this.exceptionId = exceptionId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public LocalDate getDetectedDate() {
		return detectedDate;
	}
	public void setDetectedDate(LocalDate detectedDate) {
		this.detectedDate = detectedDate;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    // getters & setters
}