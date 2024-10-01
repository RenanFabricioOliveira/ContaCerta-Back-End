package com.contacerta.service;

import java.util.List;

import com.contacerta.dto.BancoDto;
import com.contacerta.model.Banco;

public interface IBancoService {
	
	List<Banco> listar();
	Banco registrar(BancoDto banco);
	Banco atualizar(Banco banco);
	Banco excluir(int id);
	Banco listarPorId(int id);

}
