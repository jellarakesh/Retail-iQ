package com.example.controller;

import com.example.entity.FulfillmentInstruction;
import com.example.service.FulfillmentInstructionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fulfillments")
public class FulfillmentInstructionController {

    private final FulfillmentInstructionService fulfillmentService;

    public FulfillmentInstructionController(
            FulfillmentInstructionService fulfillmentService) {
        this.fulfillmentService = fulfillmentService;
    }

    @PostMapping
    public FulfillmentInstruction createFulfillment(
            @RequestBody FulfillmentInstruction instruction) {
        return fulfillmentService
                .createFulfillmentInstruction(instruction);
    }

    @GetMapping("/{id}")
    public FulfillmentInstruction getById(
            @PathVariable int id) {
        return fulfillmentService.getInstructionById(id);
    }

    @GetMapping("/order/{orderID}")
    public List<FulfillmentInstruction> getByOrder(
            @PathVariable int orderID) {
        return fulfillmentService.getByOrderID(orderID);
    }

    @GetMapping("/status/{status}")
    public List<FulfillmentInstruction> getByStatus(
            @PathVariable String status) {
        return fulfillmentService.getByStatus(status);
    }
}