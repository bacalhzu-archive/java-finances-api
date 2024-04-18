package com.littlesekii.finances.controller;

import com.littlesekii.finances.model.dto.TransactionDTO;
import com.littlesekii.finances.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> get() {
        List<TransactionDTO> res = service.findAll();
        return ResponseEntity.ok().body(res);
    }
    @GetMapping(params = {"incoming"})
    public ResponseEntity<List<TransactionDTO>> get(@RequestParam Boolean incoming) {
        List<TransactionDTO> res = service.findAllByIncoming(incoming);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> create(@RequestBody TransactionDTO req) {
        TransactionDTO res = service.create(req);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(res.id()).toUri();
        return ResponseEntity.created(location).body(res);
    }
}
