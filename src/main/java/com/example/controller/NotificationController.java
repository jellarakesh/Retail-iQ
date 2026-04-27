package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.NotificationDTO;
import com.example.dto.NotificationResponseDTO;
import com.example.entity.Notification;
import com.example.service.NotificationService;
import org.springframework.data.domain.Page;
@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping("/addNotification")
    public ResponseEntity<NotificationResponseDTO> addNotification(
            @RequestBody NotificationDTO dto) {

        Notification n = service.save(dto.getNotification());

        NotificationResponseDTO res = new NotificationResponseDTO();
        res.setNotification(n);
        res.setStatusCode(201);
        res.setMessage("Notification added successfully");

        return ResponseEntity.status(201).body(res);
    }

    @PostMapping("/updateNotification")
    public ResponseEntity<NotificationResponseDTO> updateNotification(
            @RequestBody NotificationDTO dto) {

        Notification n = service.update(dto.getNotification());

        NotificationResponseDTO res = new NotificationResponseDTO();
        res.setNotification(n);
        res.setStatusCode(200);
        res.setMessage("Notification updated successfully");

        return ResponseEntity.status(200).body(res);
    }

    @DeleteMapping("/deleteNotification")
    public String deleteNotification(@RequestBody Notification notification) {
        service.delete(notification.getNotificationId());
        return "Notification deleted successfully";
    }

    @GetMapping("/findNotification/{id}")
    public Notification findNotification(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/fetchAllNotifications")
    public List<Notification> fetchAllNotifications() {
        return service.getAll();
    }
    @GetMapping("/fetchNotificationsWithPagination")
    public Page<Notification> fetchNotificationsWithPagination(
            @RequestParam int page,
            @RequestParam int size) {

        return service.getAllWithPagination(page, size);
    }
}