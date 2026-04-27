package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, length = 500)
    private String message;

    // ORDER / INVENTORY / PROMOTION / EXCEPTION
    @Column(nullable = false)
    private String category;

    // NEW / READ / ACKNOWLEDGED
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    public Notification() {
        this.createdDate = LocalDateTime.now();
        this.status = "NEW";
    }

    // Getters and Setters

    public Long getNotificationId() {
        return notificationId;
    }

    public String getCategory() {
        return category;
    }

    public Long getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
