package com.Projetointegrador.controller;

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

import com.Projetointegrador.entities.Funcionario;
import com.Projetointegrador.service.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Funcionario", description = "API REST DE GERECIAMENTO DE FUNCIONARIO")
@RestController
@RequestMapping("/funcionario")
@CrossOrigin(origins = "*")
public class FuncionarioController {

	
	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}


	@GetMapping("/{id}")
	@Operation(summary = "Localiza um Funcionarios por ID")
	public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
		Funcionario Funcionario = funcionarioService.getFuncionarioById(id);
		if (Funcionario != null) {
			return ResponseEntity.ok(Funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Funcionarios")
	public ResponseEntity<List<Funcionario>> getAllFuncionario() {
		List<Funcionario> Funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.ok(Funcionario);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Funcionarios")
	public ResponseEntity<Funcionario> criarFuncionario(@RequestBody @Valid Funcionario funcionario) {
		Funcionario criarFuncionario = funcionarioService.salvarFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarFuncionario);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Alterar um Funcionarios")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario) {
		Funcionario updatedFuncionario = funcionarioService.updateFuncionario(id, funcionario);
		if (updatedFuncionario != null) {
			return ResponseEntity.ok(updatedFuncionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um Funcionarios")
	public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
		boolean deleted = funcionarioService.deleteFuncionario(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
