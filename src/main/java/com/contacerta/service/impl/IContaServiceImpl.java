package com.contacerta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacerta.dto.ContaDto;
import com.contacerta.model.Conta;
import com.contacerta.repository.IContaRepository;
import com.contacerta.service.IContaService;


@Service
public class IContaServiceImpl implements IContaService{
	
	@Autowired
	IContaRepository repo;
	
	private Conta parseConta(ContaDto ContaDto) {
		
		Conta Conta = new Conta();
		Conta.setIdConta(ContaDto.getIdConta());
		Conta.setTipoDivida(ContaDto.getTipoDivida());
		Conta.setValorDivida(ContaDto.getValorDivida());
		Conta.setDataDeVencimento(ContaDto.getDataDeVencimento());
		Conta.setParcela(ContaDto.getParcela());
		
		return Conta;	
	}
	
	@Override
	public List<Conta> listar() {
		return repo.findAll();
	}

	@Override
	public Conta registrar(ContaDto contaDto) {
		Conta conta = parseConta(contaDto);
		return repo.save(conta);
	}

	@Override
	public Conta atualizar(ContaDto contaDto) {
		Conta conta = parseConta(contaDto);
		return repo.save(conta);
	}

	@Override
	public Conta excluir(int id) {
		Conta conta = repo.findById(id).orElse(null);
		if (conta != null) {
			repo.deleteById(id);		
		}
		return conta;
	}

	@Override
	public Conta listarPorId(int id) {
		return repo.findById(id).orElse(null);
	}
}
