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

import com.Projetointegrador.entities.Fornecedor;
import com.Projetointegrador.service.FornecedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Fornecedor", description = "API REST DE GERECIAMENTO DE FORNECEDOR")
@RestController
@RequestMapping("/fornecedor")
@CrossOrigin(origins = "*")
public class FornecedorController {
	
	private final FornecedorService fornecedorService;

	@Autowired
	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}


	@GetMapping("/{id}")
	@Operation(summary = "Localiza um Fornecedor por ID")
	public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id) {
		Fornecedor Fornecedor = fornecedorService.getFornecedorById(id);
		if (Fornecedor != null) {
			return ResponseEntity.ok(Fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Fornecedores")
	public ResponseEntity<List<Fornecedor>> getAllFornecedor() {
		List<Fornecedor> Fornecedor = fornecedorService.getAllFornecedor();
		return ResponseEntity.ok(Fornecedor);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Fornecedores")
	public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody @Valid Fornecedor fornecedor) {
		Fornecedor criarFornecedor = fornecedorService.salvarFornecedor(fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarFornecedor);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Alterar um Fornecedores")
	public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody @Valid Fornecedor fornecedor) {
		Fornecedor updatedFornecedor = fornecedorService.updateFornecedor(id, fornecedor);
		if (updatedFornecedor != null) {
			return ResponseEntity.ok(updatedFornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um Fornecedores")
	public ResponseEntity<String> deleteFornecedor(@PathVariable Long id) {
		boolean deleted = fornecedorService.deleteFornecedor(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
