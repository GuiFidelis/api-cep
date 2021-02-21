package com.cep.api.service;

import java.util.List;
import java.util.Optional;

import com.cep.api.model.Cep;
import com.cep.api.repository.CepRepository;
import com.cep.api.error.ResourceConflictException;
import com.cep.api.error.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {
    
    @Autowired
	CepRepository cepRepository;

    public Cep compararCep(long cep){
        return  cepRepository.findByFaixaInicioLessThanEqualAndFaixaFimGreaterThanEqual(cep, cep);
           
    }
   
    public List< Cep> localizaTodos(){
		return cepRepository.findAll();
	}

    public Cep localizaId(long id) throws ResourceNotFoundException{
        return  cepRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
           
    }
    public Cep localizaCep(long cep){
        Cep cepEncontrado = compararCep(cep);

        if (cepEncontrado == null) {
			throw new ResourceNotFoundException("cep nao encontrado");
		} else{
            return cepEncontrado;
        } 
   
    }

    public Cep cadastrar(Cep cep) {
		 Cep cepInicio = compararCep(cep.getFaixaInicio());
         Cep cepFim = compararCep(cep.getFaixaFim());

		if (cepInicio != null || cepFim != null) {
			throw new ResourceConflictException("Conflito com área de cep já cadastrado");
		} else{
            return cepRepository.save(cep);
        } 

	}

    public Cep alterar(Cep cep) {
        Cep cepAlteracao = localizaId(cep.getId());
        Cep cepInicio = compararCep(cep.getFaixaInicio());
        Cep cepFim = compararCep(cep.getFaixaFim());

        if(cepAlteracao != null){
            if (cepInicio != null || cepFim != null) {
                throw new ResourceConflictException("Conflito com área de cep já cadastrado");
             } else{
                 return cepRepository.save(cep);
             } 
             
         }else{
            throw new ResourceNotFoundException("Id não encontrado");
         }
   }


    public void deletar(long id){
        Cep cepEncontrado = localizaId(id);
        if (cepEncontrado == null) {
            throw new ResourceConflictException("Não foi possivel deletar esse Id");
           }else {
            	cepRepository.delete(cepEncontrado);
           	}
    }

}

   

