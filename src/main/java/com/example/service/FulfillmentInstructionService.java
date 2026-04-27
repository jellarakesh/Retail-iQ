package com.example.service;

import com.example.entity.FulfillmentInstruction;
import com.example.repository.FulfillmentInstructionRepository;
import com.example.repository.FulfillmentItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FulfillmentInstructionService {

    private final FulfillmentInstructionRepository instructionRepository;
    private final FulfillmentItemRepository itemRepository;

    public FulfillmentInstructionService(
            FulfillmentInstructionRepository instructionRepository,
            FulfillmentItemRepository itemRepository) {
        this.instructionRepository = instructionRepository;
        this.itemRepository = itemRepository;
    }

    public FulfillmentInstruction createFulfillmentInstruction(
            FulfillmentInstruction instruction) {

        instruction.setStatus("CREATED");

        FulfillmentInstruction savedInstruction =
                instructionRepository.save(instruction);

        if (instruction.getItems() != null) {
            for (FulfillmentItem item : instruction.getItems()) {
                item.setInstructionID(
                        savedInstruction.getInstructionID());
                itemRepository.save(item);
            }
        }

        return savedInstruction;
    }

    public FulfillmentInstruction getInstructionById(int instructionID) {
        return instructionRepository
                .findById(instructionID)
                .orElse(null);
    }

    public List<FulfillmentInstruction> getByOrderID(int orderID) {
        return instructionRepository.findByOrderID(orderID);
    }

    public List<FulfillmentInstruction> getByStatus(String status) {
        return instructionRepository.findByStatus(status);
    }
}