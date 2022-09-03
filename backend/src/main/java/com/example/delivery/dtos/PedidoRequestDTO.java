package com.example.delivery.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.delivery.StatusPedido;
import com.example.delivery.entidade.Cliente;

public class PedidoRequestDTO implements Serializable {

	private Long id;

	private Long idPedido;

	public Long getIdCliente() {
		return idPedido;
	}

	public void setIdCliente(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
