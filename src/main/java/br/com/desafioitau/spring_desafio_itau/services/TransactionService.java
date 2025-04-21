package br.com.desafioitau.spring_desafio_itau.services;

import java.time.OffsetDateTime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.desafioitau.spring_desafio_itau.dto.TransactionDto;
import br.com.desafioitau.spring_desafio_itau.models.Transaction;

@Service
public class TransactionService {
    Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(Double value, OffsetDateTime dateHour) {
        transactions.add(new Transaction(value, dateHour));
    }

    public Queue<TransactionDto> getTransactions() {
        return transactions.stream()
        .map(transaction -> new TransactionDto(transaction.getValue(), transaction.getDateHour()))
        .collect(Collectors.toCollection(ConcurrentLinkedQueue::new));
    }

    public void clearTransactions () {
        transactions.clear();
    }

}
