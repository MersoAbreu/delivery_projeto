package com.example.delivery.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.delivery.StatusPedido;
import com.example.delivery.entidade.Cliente;

public class PedidoRequestDTO implements Serializable {

	private Long id;

	private Long idCliente;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
