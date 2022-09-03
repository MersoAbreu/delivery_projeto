package com.example.delivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.dtos.ClienteRequestDTO;
import com.example.delivery.dtos.ClienteResponseDTO;
import com.example.delivery.service.ClienteService;

@RestController
@RequestMapping( "/clientes")
public class ClienteController {
	
	
	private final ClienteService  clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO){
		return ResponseEntity.ok(this.clienteService.salvar(clienteRequestDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteResponseDTO>> buscarTodos(){
		return ResponseEntity.ok(this.clienteService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(this.clienteService.buscarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
		this.clienteService.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponseDTO> alterarCliente(@PathVariable(name="id") Long id, @RequestBody ClienteRequestDTO clienteRequestDTO){
		return ResponseEntity.ok(this.clienteService.alterarCliente(id, clienteRequestDTO));
	}

}
