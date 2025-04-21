package br.com.desafioitau.spring_desafio_itau.controllers;

import java.util.DoubleSummaryStatistics;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioitau.spring_desafio_itau.dto.StatisticsResponse;
import br.com.desafioitau.spring_desafio_itau.dto.TransactionDto;
import br.com.desafioitau.spring_desafio_itau.services.StatisticsService;
import br.com.desafioitau.spring_desafio_itau.services.TransactionService;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    
    StatisticsService statisticsService;
    
    TransactionService transactionService;
    
    
    
    public StatisticsController(StatisticsService statisticsService, TransactionService transactionService) {
		this.statisticsService = statisticsService;
		this.transactionService = transactionService;
	}



	@GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {
        Queue <TransactionDto> transactions = transactionService.getTransactions();
        DoubleSummaryStatistics stats = statisticsService.getStatistics(transactions);

        return ResponseEntity.ok(new StatisticsResponse(stats));
    }
}
