package com.cep.api.service;

import java.util.List;

import com.cep.api.model.Cep;
import com.cep.api.repository.CepRepository;
import com.cep.api.error.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {
    
    @Autowired
	CepRepository cepRepository;

    public List< Cep> buscarTodos(){
		return cepRepository.findAll();
	}

    public Cep localizaCep(long cep) throws ResourceNotFoundException{
        return  cepRepository.findByFaixaInicioLessThanEqualAndFaixaFimGreaterThanEqual(cep, cep)
            .orElseThrow(() -> new ResourceNotFoundException("Faixa de CEP não encontrada"));
           
    }
}

   

