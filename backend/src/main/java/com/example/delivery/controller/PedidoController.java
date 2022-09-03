package com.example.delivery.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.dtos.PedidoResponseDTO;
import com.example.delivery.dtos.PedidoRequestDTO;
import com.example.delivery.service.PedidoService;

@RequestMapping("/pedidos")
@RestController 
public class PedidoController {

	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@PostMapping
	public ResponseEntity<PedidoResponseDTO> salvar(@RequestBody PedidoRequestDTO pedidoRequestDTO){
		return ResponseEntity.ok(this.pedidoService.salvar(pedidoRequestDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<PedidoResponseDTO>> buscarTodos(){
		return ResponseEntity.ok(this.pedidoService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoResponseDTO> buscarPorId(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(this.pedidoService.buscarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
		this.pedidoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PedidoResponseDTO> alterarPedido(@PathVariable(name = "id") Long id, @RequestBody PedidoRequestDTO pedidoRequestDTO){
		return ResponseEntity.ok(this.pedidoService.alterarPedido(id, pedidoRequestDTO));
		
	}
	
}
