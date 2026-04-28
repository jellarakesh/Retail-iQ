package com.example.service;

import com.example.entity.Notification;
import com.example.exception.UserNotFoundException;
import com.example.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification save(Notification notification) {
        if (notification.getCreatedDate() == null) {
            notification.setCreatedDate(LocalDateTime.now());
        }
        return notificationRepository.save(notification);
    }

    public Notification getById(Long id) {
        return notificationRepository.findById(id)
            .orElseThrow(() ->
                new UserNotFoundException("Notification not found with id " + id));
    }

    public List<Notification> getByUser(Long userId) {
        return notificationRepository.findByUserUserId(userId);
    }

    public Page<Notification> getAll(Pageable pageable) {
        return (Page<Notification>) notificationRepository.findAll();
    }

    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
    public Page<Notification> getAllNotificationsWithPagination(Pageable pageable) {
        return this.notificationRepository.findAll(pageable);
    }

}