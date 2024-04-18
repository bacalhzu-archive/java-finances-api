package com.littlesekii.finances.model.dto;

import com.littlesekii.finances.model.TransactionEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record TransactionDTO (UUID id, @NotNull Integer value, @NotNull String description, @Valid Instant moment, @NotNull Boolean incoming){

    public static TransactionDTO fromEntity(TransactionEntity entity) {
        return new TransactionDTO(
            entity.getId(),
            entity.getValue(),
            entity.getDescription(),
            entity.getMoment(),
            entity.getIncoming()
        );
    }

    public TransactionEntity toEntity() {
        return new TransactionEntity(
            id,
            value,
            description,
            moment,
            incoming
        );
    }
    public TransactionEntity toEntity(UUID id) {
        return new TransactionEntity(
            id,
            value,
            description,
            moment,
            incoming
        );
    }
}
