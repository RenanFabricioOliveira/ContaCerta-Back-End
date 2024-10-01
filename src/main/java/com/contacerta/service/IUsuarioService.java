package com.contacerta.service;

import java.util.List;

import com.contacerta.dto.UsuarioDto;
import com.contacerta.model.Usuario;

public interface IUsuarioService {

	List<Usuario> listar();
	Usuario registrar(UsuarioDto usuario);
	Usuario atualizar(UsuarioDto usuario);
	Usuario excluir(int id);
	Usuario listarPorId(int id);
}
