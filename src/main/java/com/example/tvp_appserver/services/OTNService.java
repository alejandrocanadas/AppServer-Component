package com.example.tvp_appserver.services;

import org.springframework.stereotype.Service;

import jakarta.websocket.server.ServerEndpoint;

import com.example.tvp_appserver.model.CompraRequestDTO;

@Service
public class OTNService {
    public void validarPaquete(CompraRequestDTO compraRequestDTO){
        switch(compraRequestDTO.getId_paquete()){
            case "PKG001":
                compraRequestDTO.setEstado_compra("APROBADO");
            case "PKG002":
                compraRequestDTO.setEstado_compra("RECHAZADO");
            default:
                compraRequestDTO.setEstado_compra("PENDIENTE");
        }
    }
}
