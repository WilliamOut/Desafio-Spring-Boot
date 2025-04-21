package br.com.desafioitau.spring_desafio_itau.controllers;

import java.time.OffsetDateTime;
import java.util.Queue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioitau.spring_desafio_itau.dto.TransactionDto;
import br.com.desafioitau.spring_desafio_itau.services.TransactionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/transacao")
public class TransactionController {
    
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> addTransaction(@RequestBody TransactionDto request) {
        OffsetDateTime now = OffsetDateTime.now();

        if(request.getDateHour().isAfter(now) || request.getValue() < 0 || request.getValue() == null || request.getDateHour() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        transactionService.addTransaction(request.getValue(), request.getDateHour());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Queue<TransactionDto> getTransactions() {
        return transactionService.getTransactions();
    }
    
    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build(); 
    }
}