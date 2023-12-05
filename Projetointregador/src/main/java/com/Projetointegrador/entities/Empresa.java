package com.Projetointegrador.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Empresa")
public class Empresa {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
	

	@NotBlank
	private String nome;
	

	@NotBlank
	private String cnpj;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String socios;
	
	@NotNull
	private double faturamento;

}
