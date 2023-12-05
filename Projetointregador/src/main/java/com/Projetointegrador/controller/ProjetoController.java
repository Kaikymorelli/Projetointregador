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

import com.Projetointegrador.entities.Projeto;
import com.Projetointegrador.service.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Projeto", description = "API REST DE GERECIAMENTO DE PROJETO")
@RestController
@RequestMapping("/projeto")
@CrossOrigin(origins = "*")
public class ProjetoController {

	private final ProjetoService projetoService;

	@Autowired
	public ProjetoController(ProjetoService projetoService) {
		this.projetoService = projetoService;
	}


	@GetMapping("/{id}")
	@Operation(summary = "Localiza um Projetos por ID")
	public ResponseEntity<Projeto> getProjetoById(@PathVariable Long id) {
		Projeto Projeto = projetoService.getProjetoById(id);
		if (Projeto != null) {
			return ResponseEntity.ok(Projeto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Projetos")
	public ResponseEntity<List<Projeto>> getAllProjeto() {
		List<Projeto> Projeto = projetoService.getAllProjeto();
		return ResponseEntity.ok(Projeto);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Projeto")
	public ResponseEntity<Projeto> criarProjeto(@RequestBody @Valid Projeto projeto) {
		Projeto criarProjeto = projetoService.salvarProjeto(projeto);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarProjeto);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Alterar um Projeto")
	public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody @Valid Projeto projeto) {
		Projeto updatedProjeto = projetoService.updateProjeto(id, projeto);
		if (updatedProjeto != null) {
			return ResponseEntity.ok(updatedProjeto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um Projeto")
	public ResponseEntity<String> deleteProjeto(@PathVariable Long id) {
		boolean deleted = projetoService.deleteProjeto(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
