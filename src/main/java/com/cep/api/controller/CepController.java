package com.cep.api.controller;

import java.util.List;

import com.cep.api.model.Cep;
import com.cep.api.service.CepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
	public CepService cepService;

    @GetMapping("/todos")
	public ResponseEntity<List< Cep>> buscarLojas() {
		List< Cep > lojasBuscadas= cepService.buscarTodos();
		return new ResponseEntity<>(lojasBuscadas, HttpStatus.OK);
	}

    @GetMapping("/{cep}")
	public Cep encontrarPorCEP(@PathVariable long cep) {
        return cepService.localizaCep(cep);
	}

}
