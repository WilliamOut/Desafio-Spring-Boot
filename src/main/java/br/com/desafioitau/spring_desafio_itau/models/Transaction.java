package br.com.desafioitau.spring_desafio_itau.models;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;
    private OffsetDateTime dateHour;
    
    public Transaction () {}
    
	public Transaction(Double value, OffsetDateTime dateHour) {
		this.value = value;
		this.dateHour = dateHour;
	}
    
	public Double getValue() {
		return value;
	}
	
	public OffsetDateTime getDateHour() {
		return dateHour;
	}
	
    public Long getId() {
		return id;
	}

}
