package com.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, length = 100)
    private String name;

    
    @Column(nullable = false, length = 30)
    private String role;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(length = 20)
    private String phone;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<AuditLog> auditLogs;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Notification> notifications;

    public User() {
    }

    public User(String name, String role, String email, String phone) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setAuditLogs(List<AuditLog> auditLogs) {
		this.auditLogs = auditLogs;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<AuditLog> getAuditLogs() {
        return auditLogs;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setName(String name) {
        this.name = name;
    }

 

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}