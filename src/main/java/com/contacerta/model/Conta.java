package com.contacerta.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="conta")
public class Conta {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConta;
	
	@Column
	private String tipoDivida;
	
	@Column
	private double valorDivida;
	
	@Column
	private Date dataDeVencimento;
	
	@Column
	private int parcela;
}
