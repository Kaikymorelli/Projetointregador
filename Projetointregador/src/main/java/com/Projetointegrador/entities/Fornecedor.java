package com.Projetointegrador.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Fornecedor")
public class Fornecedor {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
	

	@NotBlank
	private String nome;
	

	@NotBlank
	private String cnpj;
	

	@NotBlank
	private String ie;
	
	
	@NotBlank
	private String endereco;
	
	
	@NotBlank
	@Email(message = "Email is not valid")
	private String email;
	
	
	
	

}
