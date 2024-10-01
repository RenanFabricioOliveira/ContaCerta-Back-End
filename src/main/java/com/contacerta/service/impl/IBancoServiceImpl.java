package com.contacerta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacerta.dto.BancoDto;
import com.contacerta.model.Banco;
import com.contacerta.model.Conta;
import com.contacerta.model.Usuario;
import com.contacerta.repository.IBancoRepository;
import com.contacerta.service.IBancoService;

@Service
public class IBancoServiceImpl implements IBancoService{
	
	@Autowired
	IBancoRepository repo;
	
	@Autowired
	private IContaServiceImpl contaServiceImpl;

	private Banco parseBanco(BancoDto bancoDto) {
		
		Banco banco = new Banco();
		banco.setIdBanco(bancoDto.getIdBanco());
		banco.setNomeBanco(bancoDto.getNomeBanco());
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(bancoDto.getUsuario_idUsuario());
		banco.setUsuario_idUsuario(usuario);
		
		Conta conta = new Conta();
		conta.setIdConta(bancoDto.getConta_idConta());
		banco.setConta_idConta(conta);
		
		return banco;	
	}

	@Override
	public List<Banco> listar() {
		return repo.findAll();
	}

	@Override
	public Banco registrar(BancoDto bancoDTO) {
		Conta listarConta = contaServiceImpl.listarPorId(bancoDTO.getConta_idConta());
		Banco banco = new Banco();
		
		if ( listarConta != null) {
			banco = repo.save(parseBanco(bancoDTO));
		}
		
		return banco;
	}
	
	@Override
	public Banco atualizar(Banco banco) {
		return repo.save(banco);
	}

	@Override
	public Banco excluir(int id) {
		Banco banco = repo.findById(id).orElse(null);
		if (banco != null) {
			repo.delete(banco);
		}
		return banco;
	}

	@Override
	public Banco listarPorId(int id) {
		return repo.findById(id).orElse(null);
	}

}