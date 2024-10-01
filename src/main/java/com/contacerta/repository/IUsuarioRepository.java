package com.contacerta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacerta.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
