package com.example.repository;

import com.example.entity.FulfillmentInstruction;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FulfillmentInstructionRepository extends JpaRepository<FulfillmentInstruction, Integer> {


}
