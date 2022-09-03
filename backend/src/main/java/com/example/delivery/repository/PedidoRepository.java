package com.example.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.delivery.entidade.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	
}
