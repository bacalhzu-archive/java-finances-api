package com.littlesekii.finances.service;

import com.littlesekii.finances.model.dto.TransactionDTO;
import com.littlesekii.finances.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<TransactionDTO> findAll() {
        List<TransactionDTO> res = new ArrayList<>();

        var data = repository.findAll();
        data.forEach(transactionEntity ->
            res.add(TransactionDTO.fromEntity(transactionEntity))
        );

        return res;
    }

    public List<TransactionDTO> findAllByIncoming(Boolean incoming) {
        List<TransactionDTO> res = new ArrayList<>();

        var data = repository.findAllByIncoming(incoming);
        data.forEach(transactionEntity ->
            res.add(TransactionDTO.fromEntity(transactionEntity))
        );

        return res;
    }

    public TransactionDTO create(TransactionDTO req) {
        var entity = req.toEntity(null);

        //get current moment if it's not specified
        if (entity.getMoment() == null)
            entity.setMoment(Instant.now());

        return TransactionDTO.fromEntity(
            repository.save(entity)
        );
    }
}
