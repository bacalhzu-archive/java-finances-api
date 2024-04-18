package com.littlesekii.finances.repository;

import com.littlesekii.finances.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findAllByIncoming(Boolean incoming);
}