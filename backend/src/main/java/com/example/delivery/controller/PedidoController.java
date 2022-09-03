package com.example.delivery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
