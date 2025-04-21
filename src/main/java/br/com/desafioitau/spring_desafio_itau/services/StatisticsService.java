package br.com.desafioitau.spring_desafio_itau.services;

import java.util.DoubleSummaryStatistics;
import java.util.Queue;

import org.springframework.stereotype.Service;

import br.com.desafioitau.spring_desafio_itau.dto.TransactionDto;


@Service
public class StatisticsService {

    public DoubleSummaryStatistics getStatistics (Queue <TransactionDto> transaction) {
        return transaction.stream()
               .mapToDouble(TransactionDto::getValue)
               .summaryStatistics();
    }
}
