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

import com.contacerta.dto.ContaDto;
import com.contacerta.model.Conta;
import com.contacerta.model.Conta;
import com.contacerta.service.IContaService;


;

@RestController
@RequestMapping("/conta")
@CrossOrigin("http://localhost:4200")
public class ContaController {
	
	@Autowired
	private IContaService service;
	
	@GetMapping
	public ResponseEntity<List<Conta>> listar() {
		List<Conta> list = service.listar();
		return new ResponseEntity<List<Conta>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity <Conta> registrar(@RequestBody ContaDto contaDto) {
		Conta c = service.registrar(contaDto);
		return new ResponseEntity<Conta>(c, HttpStatus.OK);
	}

	@PutMapping(path = { "/{id}" }) 
	public Conta atualizar(@RequestBody ContaDto contaDto, @PathVariable("id") int idConta) { 
		contaDto.setIdConta(idConta);
		return service.atualizar(contaDto); 
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> excluir(@PathVariable ("id") int idConta) throws Exception { 
		Conta c = service.excluir(idConta); 
		if(c == null) { 
			throw new Exception("Id não encontrado!"); 
		} 
		service.excluir(idConta); 
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping ("/{id}") 
	public ResponseEntity<Conta> listarPorId(@PathVariable ("id")int idConta) throws Exception{ 
		Conta c = service.listarPorId(idConta); 
		if(c == null) { 
			throw new Exception("ID do Conta não encontrado!"); 
		} 
		return new ResponseEntity<Conta> (c, HttpStatus.OK);
	}
}

