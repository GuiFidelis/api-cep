package com.cep.api.service;


import com.cep.api.repository.CepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {
    
    @Autowired
	CepRepository cepRepository;

    
}
