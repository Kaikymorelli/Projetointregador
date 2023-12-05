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

import com.Projetointegrador.entities.DepartamentoP;
import com.Projetointegrador.service.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Departamento", description = "API REST DE GERECIAMENTO DE DEPARTAMENTO")
@RestController
@RequestMapping("/departamento")
@CrossOrigin(origins = "*")
public class DepartamentoController {
	
	private final DepartamentoService departamentoService;

	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}


	@GetMapping("/{id}")
	@Operation(summary = "Localiza um Departamentos por ID")
	public ResponseEntity<DepartamentoP> getDepartamentoById(@PathVariable Long id) {
		DepartamentoP Departamento = departamentoService.getDepartamentoById(id);
		if (Departamento != null) {
			return ResponseEntity.ok(Departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Departamentos")
	public ResponseEntity<List<DepartamentoP>> getAllDepartamento() {
		List<DepartamentoP> Departamento = departamentoService.getAllDepartamento();
		return ResponseEntity.ok(Departamento);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Departamentos")
	public ResponseEntity<DepartamentoP> criarDepartamento(@RequestBody @Valid DepartamentoP departamento) {
		DepartamentoP criarDepartamento = departamentoService.salvarDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarDepartamento);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Alterar um Departamentos")
	public ResponseEntity<DepartamentoP> updateDepartamento(@PathVariable Long id, @RequestBody @Valid DepartamentoP departamento) {
		DepartamentoP updatedDepartamento = departamentoService.updateDepartamento(id, departamento);
		if (updatedDepartamento != null) {
			return ResponseEntity.ok(updatedDepartamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um Departamentos")
	public ResponseEntity<String> deleteDepartamento(@PathVariable Long id) {
		boolean deleted = departamentoService.deleteDepartamento(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
