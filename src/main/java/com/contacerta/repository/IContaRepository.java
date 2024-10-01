package com.contacerta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacerta.model.Conta;

public interface IContaRepository extends JpaRepository<Conta, Integer> {

}
