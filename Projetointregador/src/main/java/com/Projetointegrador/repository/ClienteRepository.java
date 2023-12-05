package com.Projetointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projetointegrador.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
