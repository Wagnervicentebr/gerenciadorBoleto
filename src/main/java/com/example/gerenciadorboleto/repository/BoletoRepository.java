package com.example.gerenciadorboleto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerenciadorboleto.model.Boleto;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Integer>{

}
