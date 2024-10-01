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

import com.contacerta.dto.BancoDto;
import com.contacerta.model.Banco;
import com.contacerta.service.IBancoService;

@RestController
@RequestMapping("/banco")
@CrossOrigin("http://localhost:4200")
public class BancoController {
	
	@Autowired
	IBancoService service;
	
	@GetMapping
	public ResponseEntity <List <Banco>> listar() {
		List<Banco> list = service.listar();
		return new ResponseEntity<List<Banco>>(list, HttpStatus.OK);
	}	

	@PostMapping
	public ResponseEntity <Banco> registrar(@RequestBody BancoDto BancoDto) throws Exception {
		Banco a = service.registrar(BancoDto);
		if (a.getIdBanco() == 0) {
			return new ResponseEntity<Banco>(a, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Banco>(a, HttpStatus.OK);
		}
	}

	@GetMapping(path = {"/{id}"}) 
	public ResponseEntity<Banco> listarPorId(@PathVariable ("id")int id) throws Exception{ 
		Banco a = service.listarPorId(id); 
		if(a == null){ 
			throw new Exception("Id não encontrado!"); 
		}
		return new ResponseEntity<Banco>(a, HttpStatus.OK); 
	}

	@PutMapping(path = {"/{id}"})
	public Banco atualizar(@RequestBody Banco Banco, @PathVariable("id") int id){
		Banco.setIdBanco(id);
		return service.atualizar(Banco);
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> excluir(@PathVariable ("id") int id) throws Exception{ 
		Banco a = service.listarPorId(id); 
		if(a == null){ 
			throw new Exception("Id não encontrado!"); 
		} 
		service.excluir(id); 
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
