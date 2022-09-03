package com.example.delivery.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.delivery.StatusPedido;
import com.example.delivery.entidade.Cliente;

public class PedidoResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String numeroPedido;
	
	private LocalDate dataPedido;

	private ClienteResponseDTO cliente;
	
	private StatusPedido statusPedido;
	
	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public ClienteResponseDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResponseDTO cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}
	
	
}
