package com.example.delivery.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.delivery.dtos.ClienteResponseDTO;
import com.example.delivery.dtos.PedidoRequestDTO;
import com.example.delivery.dtos.PedidoResponseDTO;
import com.example.delivery.entidade.Cliente;
import com.example.delivery.entidade.Pedido;
import com.example.delivery.repository.PedidoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	private final ClienteService clienteService;
	
	public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService) {

		this.pedidoRepository = pedidoRepository;
		this.clienteService = clienteService;
	}

	public PedidoResponseDTO salvar(PedidoRequestDTO pedidoRequestDTO) {
		
		Cliente cliente = this.clienteService.buscarClientePorId(pedidoRequestDTO.getIdCliente());
		
		UUID uuid = UUID.randomUUID();
		Pedido pedido = new Pedido();
		pedido.setNumeroPedido(uuid.toString());
		pedido.setCliente(cliente);
		pedido.setDataPedido(LocalDate.now());
		pedido.setStatusPedido(pedido.getStatusPedido().ABERTO);
		pedido = this.pedidoRepository.save(pedido);
		
		ClienteResponseDTO clienteResponse = new ClienteResponseDTO();
		clienteResponse.setId(pedido.getCliente().getId());
		clienteResponse.setNome(pedido.getCliente().getNome());
		
		PedidoResponseDTO pedidoResponse = new PedidoResponseDTO();
		pedidoResponse.setCliente(clienteResponse);
		pedidoResponse.setDataPedido(pedido.getDataPedido());
		pedidoResponse.setNumeroPedido(pedido.getNumeroPedido());
		pedidoResponse.setStatusPedido(pedido.getStatusPedido());
		pedidoResponse.setId(pedido.getId());		
		
		return pedidoResponse;
	}

	public List<PedidoResponseDTO> buscarTodos() {
		List<Pedido> listaPedido = this.pedidoRepository.findAll();
		List<PedidoResponseDTO> listaResponse = new ArrayList<>();
		
		for (Pedido listaPedidos : listaPedido) {
			ClienteResponseDTO clienteResponse = new ClienteResponseDTO();
			PedidoResponseDTO pedidoResponse = new PedidoResponseDTO();
			
			clienteResponse.setId(listaPedidos.getCliente().getId());
			clienteResponse.setNome(listaPedidos.getCliente().getNome());
			
			pedidoResponse.setCliente(clienteResponse);
			pedidoResponse.setDataPedido(listaPedidos.getDataPedido());
			pedidoResponse.setId(listaPedidos.getId());
			pedidoResponse.setNumeroPedido(listaPedidos.getNumeroPedido());
			pedidoResponse.setStatusPedido(listaPedidos.getStatusPedido());
			
			listaResponse.add(pedidoResponse);
		}
		
		return listaResponse;
	}

	
	
	
}
