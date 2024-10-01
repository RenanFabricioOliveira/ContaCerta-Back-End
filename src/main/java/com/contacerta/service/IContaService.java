package com.contacerta.service;

import java.util.List;

import com.contacerta.dto.ContaDto;
import com.contacerta.model.Conta;

public interface IContaService {
	
	List<Conta> listar();
	Conta registrar(ContaDto contaDto);
	Conta atualizar(ContaDto contaDto);
	Conta excluir(int id);
	Conta listarPorId(int id);

}
