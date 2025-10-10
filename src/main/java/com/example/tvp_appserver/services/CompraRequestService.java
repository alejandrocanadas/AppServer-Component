package com.example.tvp_appserver.services;

import org.springframework.stereotype.Service;

import com.example.tvp_appserver.model.CompraRequestDTO;

@Service
public class CompraRequestService {
    
    private final OTNService otnService;

    public CompraRequestService(OTNService otnService){
        this.otnService = otnService;
    }

    public CompraRequestDTO continuarCompra(CompraRequestDTO compraRequestDTO) {
        otnService.validarPaquete(compraRequestDTO); 
        return compraRequestDTO;
    }
}
