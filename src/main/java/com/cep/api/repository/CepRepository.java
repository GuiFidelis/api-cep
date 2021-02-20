package com.cep.api.repository;

import java.util.List;

import com.cep.api.model.Cep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
    public List<Cep> findAllByCodigoLojaContainingIgnoreCase(String codigoLoja);
   
    Cep findByCep(Long faixaInicio, Long faixaFim);
}
