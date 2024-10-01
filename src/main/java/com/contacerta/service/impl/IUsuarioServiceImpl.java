package com.contacerta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacerta.dto.UsuarioDto;
import com.contacerta.model.Usuario;
import com.contacerta.repository.IUsuarioRepository;
import com.contacerta.service.IUsuarioService;


@Service
public class IUsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	IUsuarioRepository repo;
	
	private Usuario parseUsuario(UsuarioDto usuarioDto) {
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuarioDto.getIdUsuario());
		usuario.setNome(usuarioDto.getNome());
		usuario.setTelefone(usuarioDto.getTelefone());
		
		return usuario;
		
	}
	
	@Override
	public List<Usuario> listar() {
		return repo.findAll();
	}

	@Override
	public Usuario registrar(UsuarioDto usuarioDto) {
		Usuario usuario = parseUsuario(usuarioDto);
		return repo.save(usuario);
	}

	@Override
	public Usuario atualizar(UsuarioDto usuarioDto) {
		Usuario usuario = parseUsuario(usuarioDto);
		return repo.save(usuario);
	}

	@Override
	public Usuario excluir(int id) {
		Usuario usuario = repo.findById(id).orElse(null);
		if (usuario != null) {
			repo.delete(usuario);
		}
		return usuario;
	}

	@Override
	public Usuario listarPorId(int id) {
		return repo.findById(id).orElse(null);
	}

}
