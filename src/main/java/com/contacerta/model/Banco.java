package com.contacerta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="banco")
public class Banco {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBanco;
	
	@Column
	private String nomeBanco;
	
	@ManyToOne
	@JoinColumn(name ="usuario_idUsuario")
	private Usuario usuario_idUsuario;
	
	@ManyToOne
	@JoinColumn(name ="conta_idConta")
	private Conta conta_idConta;
}
