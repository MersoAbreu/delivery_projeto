package com.example.delivery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.dtos.EntregaRequestDTO;
import com.example.delivery.dtos.EntregaResponseDTO;
import com.example.delivery.service.EntregaService;

@RequestMapping("/entregas")
@RestController
public class EntregaController {

	private final EntregaService entregaService;
	
	public EntregaController(EntregaService entregaService) {
		this.entregaService = entregaService;
	}
	
	@PostMapping
	public ResponseEntity<EntregaResponseDTO> salvar(@RequestBody EntregaRequestDTO entregaRequestDTO){
		return ResponseEntity.ok(this.entregaService.salvar(entregaRequestDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<EntregaResponseDTO>> buscarTodos(){
		return ResponseEntity.ok(this.entregaService.buscarTodas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaResponseDTO> buscarPorId(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(this.entregaService.buscarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Long id){
		this.entregaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EntregaResponseDTO> alterarEntrega(@PathVariable(name="id") Long id, @RequestBody EntregaRequestDTO entregaRequestDTO){
		return ResponseEntity.ok(this.entregaService.alterarEntrega(id, entregaRequestDTO));
	}
}
