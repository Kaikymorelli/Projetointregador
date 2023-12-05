package com.Projetointegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetointegrador.entities.Empresa;
import com.Projetointegrador.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private final EmpresaRepository empresaRepository;
	
	@Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

	 public List<Empresa> getAllEmpresa() {
	        return empresaRepository.findAll();
	    }

	    public Empresa getEmpresaById(Long id) {
	        Optional<Empresa> empresa = empresaRepository.findById(id);
	        return empresa.orElse(null);
	    }

	    public Empresa salvarEmpresa(Empresa empresa) {
	        return empresaRepository.save(empresa);
	    }

	    public Empresa updateEmpresa(Long id, Empresa updatedEmpresa) {
	        Optional<Empresa> existingEmpresa = empresaRepository.findById(id);
	        if (existingEmpresa.isPresent()) {
	        	updatedEmpresa.setId(id);
	            return empresaRepository.save(updatedEmpresa);
	        }
	        return null;
	    }

	    public boolean deleteEmpresa(Long id) {
	        Optional<Empresa> existingEmpresa = empresaRepository.findById(id);
	        if (existingEmpresa.isPresent()) {
	        	empresaRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

}
