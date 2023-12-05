package com.Projetointegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projetointegrador.entities.Cliente;
import com.Projetointegrador.entities.DepartamentoP;
import com.Projetointegrador.entities.Empresa;
import com.Projetointegrador.entities.Fornecedor;
import com.Projetointegrador.entities.Funcionario;
import com.Projetointegrador.entities.Projeto;
import com.Projetointegrador.service.ClienteService;
import com.Projetointegrador.service.DepartamentoService;
import com.Projetointegrador.service.EmpresaService;
import com.Projetointegrador.service.FornecedorService;
import com.Projetointegrador.service.FuncionarioService;
import com.Projetointegrador.service.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Api", description = "API REST DE GERECIAMENTO DE API")
@RestController
@RequestMapping("/apiexterna")
@CrossOrigin(origins = "*")
public class ApiexternaController {
		

	private final ClienteService clienteService;
	private final DepartamentoService departamentoService;
	private final EmpresaService empresaService;
	private final FornecedorService fornecedorService;
	private final FuncionarioService funcionarioService;
	private final ProjetoService projetoService;

	@Autowired
	public ApiexternaController (ClienteService clienteService,DepartamentoService departamentoService, EmpresaService empresaService,FornecedorService fornecedorService,FuncionarioService funcionarioService,ProjetoService projetoService ) {
		this.clienteService = clienteService;
		this.departamentoService = departamentoService;
		this.empresaService = empresaService;
		this.fornecedorService = fornecedorService;
		this.funcionarioService = funcionarioService;
		this.projetoService = projetoService;
	}

	@GetMapping("/clientes")
	@Operation(summary = "Apresenta todos os Clientes")
	public ResponseEntity<List<Cliente>> getAllCliente() {
		List<Cliente> Cliente = clienteService.getAllCliente();
		return ResponseEntity.ok(Cliente);
	}

	
	@GetMapping ("/departamento")
	@Operation(summary = "Apresenta todos os Departamentos")
	public ResponseEntity<List<DepartamentoP>> getAllDepartamento() {
		List<DepartamentoP> Departamento = departamentoService.getAllDepartamento();
		return ResponseEntity.ok(Departamento);
	}
	
	@GetMapping ("/empresa")
	@Operation(summary = "Apresenta todos os Empresas")
	public ResponseEntity<List<Empresa>> getAllEmpresa() {
		List<Empresa> Empresa = empresaService.getAllEmpresa();
		return ResponseEntity.ok(Empresa);
	}

	@GetMapping("/fornecedor")
	@Operation(summary = "Apresenta todos os Fornecedores")
	public ResponseEntity<List<Fornecedor>> getAllFornecedor() {
		List<Fornecedor> Fornecedor = fornecedorService.getAllFornecedor();
		return ResponseEntity.ok(Fornecedor);
	}
		
	@GetMapping("/funcionario")
	@Operation(summary = "Apresenta todos os Funcionarios")
	public ResponseEntity<List<Funcionario>> getAllFuncionario() {
		List<Funcionario> Funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.ok(Funcionario);
	}
	

	@GetMapping("/projeto")
	@Operation(summary = "Apresenta todos os Projetos")
	public ResponseEntity<List<Projeto>> getAllProjeto() {
		List<Projeto> Projeto = projetoService.getAllProjeto();
		return ResponseEntity.ok(Projeto);
	}
	

}
