package com.example.gerenciadorboleto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciadorboleto.model.Boleto;

public interface BoletoRepository extends JpaRepository<Boleto, Integer>{


}
