package com.contacerta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacerta.dto.UsuarioDto;
import com.contacerta.model.Usuario;
import com.contacerta.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> list = service.listar();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity <Usuario> registrar(@RequestBody UsuarioDto usuarioDTO) {
		Usuario c = service.registrar(usuarioDTO);
		return new ResponseEntity<Usuario>(c, HttpStatus.OK);
	}

	@PutMapping(path = { "/{id}" }) 
	public Usuario atualizar(@RequestBody UsuarioDto UsuarioDTO, @PathVariable("id") int idUsuario) { 
		UsuarioDTO.setIdUsuario(idUsuario); 
		return service.atualizar(UsuarioDTO); 
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> excluir(@PathVariable ("id") int idUsuario) throws Exception { 
		Usuario c = service.excluir(idUsuario); 
		if(c == null) { 
			throw new Exception("Id não encontrado!"); 
		} 
		service.excluir(idUsuario); 
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping ("/{id}") 
	public ResponseEntity<Usuario> listarPorId(@PathVariable ("id")int idUsuario) throws Exception{ 
		Usuario c = service.listarPorId(idUsuario); 
		if(c == null) { 
			throw new Exception("ID do Usuario não encontrado!"); 
		} 
		return new ResponseEntity<Usuario> (c, HttpStatus.OK);
	}
}
