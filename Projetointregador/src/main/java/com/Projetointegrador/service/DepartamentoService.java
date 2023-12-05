package com.Projetointegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetointegrador.entities.DepartamentoP;
import com.Projetointegrador.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private final DepartamentoRepository departamentoRepository;
	
	@Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

	 public List<DepartamentoP> getAllDepartamento() {
	        return departamentoRepository.findAll();
	    }

	    public DepartamentoP getDepartamentoById(Long id) {
	        Optional<DepartamentoP> departamento = departamentoRepository.findById(id);
	        return departamento.orElse(null);
	    }

	    public DepartamentoP salvarDepartamento(DepartamentoP departamento) {
	        return departamentoRepository.save(departamento);
	    }

	    public DepartamentoP updateDepartamento(Long id, DepartamentoP updatedDepartamento) {
	        Optional<DepartamentoP> existingDepartamento = departamentoRepository.findById(id);
	        if (existingDepartamento.isPresent()) {
	        	updatedDepartamento.setId(id);
	            return departamentoRepository.save(updatedDepartamento);
	        }
	        return null;
	    }

	    public boolean deleteDepartamento(Long id) {
	        Optional<DepartamentoP> existingDepartamento = departamentoRepository.findById(id);
	        if (existingDepartamento.isPresent()) {
	        	departamentoRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

}
