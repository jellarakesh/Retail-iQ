package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FulfillmentItemRepository
        extends JpaRepository<FulfillmentItem, Integer> {

    List<FulfillmentItem> findByInstructionID(int instructionID);
}