package com.example.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.delivery.entidade.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
