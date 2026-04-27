package com.example.service;

import com.example.entity.Notification;
import com.example.repository.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }


    public Notification getById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Notification not found with id: " + id));
    }


    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }
    public  Page<Notification> getAllWithPagination(int page,int size){
        Pageable pageable=PageRequest.of(page,size);
        return notificationRepository.findAll(pageable);
    }

    public Notification delete(Long id) {
        Notification notification = getById(id);
        if (notification != null) {
            notificationRepository.deleteById(id);
        }
        return notification;
    }
}