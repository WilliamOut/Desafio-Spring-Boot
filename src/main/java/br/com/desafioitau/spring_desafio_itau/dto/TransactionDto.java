package br.com.desafioitau.spring_desafio_itau.dto;

import java.time.OffsetDateTime;

import lombok.Getter;

public class TransactionDto {
    
    private Double value;
    private OffsetDateTime dateHour;

    public TransactionDto(Double value, OffsetDateTime dateHour) {
        this.value = value;
        this.dateHour = dateHour;
    }
    
    public Double getValue() {
		return value;
	}
    
    public OffsetDateTime getDateHour() {
		return dateHour;
	}
}
