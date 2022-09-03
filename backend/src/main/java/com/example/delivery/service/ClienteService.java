package com.example.delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.delivery.dtos.ClienteRequestDTO;
import com.example.delivery.dtos.ClienteResponseDTO;
import com.example.delivery.entidade.Cliente;
import com.example.delivery.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public ClienteResponseDTO salvar(ClienteRequestDTO clienteRequestDTO) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteRequestDTO.getId());
		cliente.setNome(clienteRequestDTO.getNome());
		cliente = clienteRepository.save(cliente);
		
		ClienteResponseDTO clienteresponseDTO = new ClienteResponseDTO();
		clienteresponseDTO.setId(cliente.getId());
		clienteresponseDTO.setNome(cliente.getNome());;
		
		return clienteresponseDTO;
	}

	public List<ClienteResponseDTO> buscarTodos() {
		List<Cliente> clientes = this.clienteRepository.findAll();
		List<ClienteResponseDTO> clienteResponseDTO = new ArrayList<>();
		
		for (Cliente cliente : clientes) {
			ClienteResponseDTO clienteResponse = new ClienteResponseDTO();
			clienteResponse.setId(cliente.getId());
			clienteResponse.setNome(cliente.getNome());
			clienteResponseDTO.add(clienteResponse);
		}
		
		return clienteResponseDTO;
	}

	public ClienteResponseDTO buscarPorId(Long id) {
		Cliente cliente = this.clienteRepository.findById(id).get();
		ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
		
		clienteResponseDTO.setId(cliente.getId());
		clienteResponseDTO.setNome(cliente.getNome());
		
		return clienteResponseDTO;
	}

	public void deletarCliente(Long id) {
		Cliente cliente = this.clienteRepository.findById(id).get();
		this.clienteRepository.delete(cliente);
		
	}

	public ClienteResponseDTO alterarCliente(Long id, ClienteRequestDTO clienteRequestDTO) {
		ClienteResponseDTO clienteresponseDTO = new ClienteResponseDTO();
		Cliente cliente = this.clienteRepository.findById(id).get();
		if (cliente  == null) {
			throw new NullPointerException("Cliente não encontrado");
		}
		cliente.setId(id);
		cliente.setNome(clienteRequestDTO.getNome());
		this.clienteRepository.save(cliente);
		clienteresponseDTO.setId(id);
		clienteresponseDTO.setNome(cliente.getNome());
		
		return clienteresponseDTO;
	}

	public Cliente buscarClientePorId(Long id) {
		Cliente cliente =  this.clienteRepository.findById(id).get();
		if(cliente == null) {
			throw new NullPointerException("Cliente não encontrado");
		}
		return cliente;
		
	}
}
