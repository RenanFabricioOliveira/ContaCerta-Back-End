package com.contacerta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacerta.model.Banco;

public interface IBancoRepository extends JpaRepository<Banco, Integer> {

}
