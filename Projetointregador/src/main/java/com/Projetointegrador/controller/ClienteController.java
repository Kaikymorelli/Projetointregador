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

import com.Projetointegrador.entities.Cliente;
import com.Projetointegrador.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Cliente", description = "API REST DE GERECIAMENTO DE CLIENTE")
@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}


	@GetMapping("/{id}")
	@Operation(summary = "Localiza um Cliente por ID")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		Cliente Cliente = clienteService.getClienteById(id);
		if (Cliente != null) {
			return ResponseEntity.ok(Cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Clientes")
	public ResponseEntity<List<Cliente>> getAllCliente() {
		List<Cliente> Cliente = clienteService.getAllCliente();
		return ResponseEntity.ok(Cliente);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Clientes")
	public ResponseEntity<Cliente> criarCliente(@RequestBody @Valid Cliente cliente) {
		Cliente criarCliente = clienteService.salvarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarCliente);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Alterar um Clientes")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
		Cliente updatedCliente = clienteService.updateCliente(id, cliente);
		if (updatedCliente != null) {
			return ResponseEntity.ok(updatedCliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um Clientes")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
		boolean deleted = clienteService.deleteCliente(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
