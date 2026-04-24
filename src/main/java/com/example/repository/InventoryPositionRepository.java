package com.example.repository;

import com.example.entity.InventoryPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryPositionRepository extends JpaRepository<InventoryPosition, Integer> {
}
