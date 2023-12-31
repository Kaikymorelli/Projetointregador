package com.Projetointegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetointegrador.entities.Funcionario;
import com.Projetointegrador.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	

	@Autowired
	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

	 public List<Funcionario> getAllFuncionario() {
	        return funcionarioRepository.findAll();
	    }

	    public Funcionario getFuncionarioById(Long id) {
	        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
	        return funcionario.orElse(null);
	    }

	    public Funcionario salvarFuncionario(Funcionario funcionario) {
	        return funcionarioRepository.save(funcionario);
	    }

	    public Funcionario updateFuncionario(Long id, Funcionario updatedFuncionario) {
	        Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
	        if (existingFuncionario.isPresent()) {
	        	updatedFuncionario.setId(id);
	            return funcionarioRepository.save(updatedFuncionario);
	        }
	        return null;
	    }

	    public boolean deleteFuncionario(Long id) {
	        Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
	        if (existingFuncionario.isPresent()) {
	        	funcionarioRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

}
