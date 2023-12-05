package com.Projetointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projetointegrador.entities.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
