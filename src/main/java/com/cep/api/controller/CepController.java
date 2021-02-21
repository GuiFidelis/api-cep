package com.cep.api.controller;

import java.util.List;

import com.cep.api.model.Cep;
import com.cep.api.service.CepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
	public CepService cepService;

    @GetMapping("/todos")
	public ResponseEntity<List< Cep>> buscarLojas() {
		List< Cep > lojasBuscadas= cepService.localizaTodos();
		return new ResponseEntity<>(lojasBuscadas, HttpStatus.OK);
	}

    @GetMapping("/buscaId/{id}")
	public ResponseEntity<Cep> findById(@PathVariable long id) {
        return new ResponseEntity<>(cepService.localizaId(id), HttpStatus.OK);
	}

    @GetMapping("/buscaCep/{cep}")
	public ResponseEntity<Cep> findByCep(@PathVariable long cep) {
        return new ResponseEntity<>(cepService.localizaCep(cep), HttpStatus.OK);
	}

    @PostMapping("/cadastrar")
    public ResponseEntity<Cep> post(@RequestBody Cep cep){
        Cep cepCadastrado = cepService.cadastrar(cep);
        return new ResponseEntity<>(cepCadastrado, HttpStatus.CREATED);
    }

    @PutMapping("/alterar")
    public ResponseEntity<Cep> put(@RequestBody Cep cep){
        Cep cepCadastrado = cepService.alterar(cep);
        return new ResponseEntity<>(cepCadastrado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable long id){
         cepService.deletar(id);
    }



}
