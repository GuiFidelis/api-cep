package com.cep.api.controller;

import com.cep.api.model.Cep;
import com.cep.api.service.CepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    public CepService cepService;

}
