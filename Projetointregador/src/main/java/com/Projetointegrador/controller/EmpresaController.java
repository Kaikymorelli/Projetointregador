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

import com.Projetointegrador.entities.Empresa;
import com.Projetointegrador.service.EmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Empresa", description = "API REST DE GERECIAMENTO DE EMPRESA")
@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController {
	
	private final EmpresaService empresaService;

	@Autowired
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}


	@GetMapping("/{id}")
	@Operation(summary = "Localiza um Empresas por ID")
	public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long id) {
		Empresa Empresa = empresaService.getEmpresaById(id);
		if (Empresa != null) {
			return ResponseEntity.ok(Empresa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Empresas")
	public ResponseEntity<List<Empresa>> getAllEmpresa() {
		List<Empresa> Empresa = empresaService.getAllEmpresa();
		return ResponseEntity.ok(Empresa);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Empresas")
	public ResponseEntity<Empresa> criarEmpresa(@RequestBody @Valid Empresa empresa) {
		Empresa criarEmpresa = empresaService.salvarEmpresa(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarEmpresa);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Alterar um Empresas")
	public ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id, @RequestBody @Valid Empresa empresa) {
		Empresa updatedEmpresa = empresaService.updateEmpresa(id, empresa);
		if (updatedEmpresa != null) {
			return ResponseEntity.ok(updatedEmpresa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um Empresas")
	public ResponseEntity<String> deleteEmpresa(@PathVariable Long id) {
		boolean deleted = empresaService.deleteEmpresa(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
