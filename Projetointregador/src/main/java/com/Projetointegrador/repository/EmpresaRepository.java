package com.Projetointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projetointegrador.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
