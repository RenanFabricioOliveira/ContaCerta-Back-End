package com.contacerta.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ContaDto {
	
	private int idConta;
	private String tipoDivida;
	private double valorDivida;
	private Date dataDeVencimento;
	private int parcela;
}
