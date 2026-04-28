package com.example.controller;

import com.example.entity.Notification;
import com.example.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import com.example.entity.Notification;
import com.example.service.NotificationService;

@RestController
@RequestMapping("/notification")
@Tag(name = "Notification Controller")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Notification add(@RequestBody Notification notification) {
        return service.save(notification);
    }

    @GetMapping("/find/{id}")
    public Notification get(@PathVariable Long id) {
        return service.getById(id);
    }


    @GetMapping("/fetchAllPaginated")
    public Page<Notification> getAll(
            @RequestParam int pgno,
            @RequestParam int size,
            @RequestParam String sorting,
            @RequestParam boolean asc) {

        Pageable pageable = PageRequest.of(
                pgno, size,
                asc ? Sort.by(sorting).ascending()
                    : Sort.by(sorting).descending());

        return service.getAll(pageable);
    }
}
