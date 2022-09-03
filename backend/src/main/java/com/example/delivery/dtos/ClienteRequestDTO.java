package com.example.delivery.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequestDTO {
	
	private Long id;
	
	@NotBlank(message = "Valor nulo ou invalido")
	@NotNull
	private String nome;

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
