package com.example.delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.delivery.dtos.EntregaRequestDTO;
import com.example.delivery.dtos.EntregaResponseDTO;
import com.example.delivery.entidade.Entrega;
import com.example.delivery.repository.EntregaRepository;

@Service
public class EntregaService {

	private final EntregaRepository entregaRepository;
	
	public EntregaService(EntregaRepository entregaRepository) {
		this.entregaRepository = entregaRepository;
	}

	public EntregaResponseDTO salvar(EntregaRequestDTO entregaRequestDTO) {
		Entrega entrega = new Entrega();
		
		entrega.setLogradouro(entregaRequestDTO.getLogradouro());
		entrega.setBairro(entregaRequestDTO.getBairro());
		entrega.setNumero(entregaRequestDTO.getNumero());
		entrega.setCep(entregaRequestDTO.getCep());
		entrega.setCidade(entregaRequestDTO.getCidade());
		entrega.setEstado(entregaRequestDTO.getEstado());
		entrega = this.entregaRepository.save(entrega);
		
		EntregaResponseDTO response = new EntregaResponseDTO();
		response.setId(entrega.getId());
		response.setBairro(entrega.getBairro());
		response.setCep(entrega.getCep());
		response.setCidade(entrega.getCidade());
		response.setEstado(entrega.getEstado());
		response.setLogradouro(entrega.getLogradouro());
		response.setNumero(entrega.getNumero());
		
		return response;
	}

	public List<EntregaResponseDTO> buscarTodas() {
		List<Entrega> entregas  = this.entregaRepository.findAll();
		
		List<EntregaResponseDTO> listaEntregas = new ArrayList<>();
		
		for (Entrega entrega : entregas) {
			EntregaResponseDTO entregaResponse = new EntregaResponseDTO();
			entregaResponse.setId(entrega.getId());
			entregaResponse.setBairro(entrega.getBairro());
			entregaResponse.setLogradouro(entrega.getLogradouro());
			entregaResponse.setCidade(entrega.getCidade());
			entregaResponse.setEstado(entrega.getEstado());
			entregaResponse.setNumero(entrega.getNumero());
			entregaResponse.setCep(entrega.getCep());
			listaEntregas.add(entregaResponse);
		}
		
		return listaEntregas;
	}

	public EntregaResponseDTO buscarPorId(Long id) {
		Entrega entrega = this.entregaRepository.findById(id).get();
		if(entrega == null) {
			throw new NullPointerException("Entrega não encontrada");
		}
		EntregaResponseDTO entregaResponse = new EntregaResponseDTO();
		entregaResponse.setId(entrega.getId());
		entregaResponse.setBairro(entrega.getBairro());
		entregaResponse.setNumero(entrega.getNumero());
		entregaResponse.setLogradouro(entrega.getLogradouro());
		entregaResponse.setCep(entrega.getCep());
		entregaResponse.setCidade(entrega.getCidade());
		entregaResponse.setEstado(entrega.getEstado());
		
		return entregaResponse;
	}

	public void deletar(Long id) {
		Entrega entrega = this.entregaRepository.findById(id).get();
		if(entrega == null) {
			throw new NullPointerException("Entrega não encontrada");
		}
		this.entregaRepository.delete(entrega);
	}

	public EntregaResponseDTO alterarEntrega(Long id, EntregaRequestDTO entregaRequestDTO) {
		Entrega entrega = this.entregaRepository.findById(id).get();
		if(entrega == null) {
			throw new NullPointerException("Entrega não encontrada");
		}
		
		entrega.setLogradouro(entregaRequestDTO.getLogradouro());
		entrega.setBairro(entregaRequestDTO.getBairro());
		entrega.setNumero(entregaRequestDTO.getNumero());
		entrega.setCep(entregaRequestDTO.getCep());
		entrega.setEstado(entregaRequestDTO.getEstado());
		entrega.setCidade(entregaRequestDTO.getCidade());
		
		entrega = this.entregaRepository.save(entrega);
		
		EntregaResponseDTO entregaResponse = new EntregaResponseDTO();
		
		entregaResponse.setId(id);
		entregaResponse.setLogradouro(entrega.getLogradouro());
		entregaResponse.setBairro(entrega.getBairro());
		entregaResponse.setNumero(entrega.getNumero());
		entregaResponse.setCep(entrega.getCep());
		entregaResponse.setEstado(entrega.getEstado());
		entregaResponse.setCidade(entrega.getCidade());
	
		
		return entregaResponse;
	}

	
}
