package com.example.tvp_appserver.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import jakarta.websocket.server.ServerEndpoint;

import com.example.tvp_appserver.model.CompraRequestDTO;
import com.example.tvp_appserver.model.DetalleCompraDTO;

@Service
public class OTNService {
        public void validarPaquete(DetalleCompraDTO detalle) {
        Random random = new Random();
        int result = random.nextInt(3);
        switch (result) {
            case 0 -> detalle.setEstadoValidacion("APROBADO");
            case 1 -> detalle.setEstadoValidacion("RECHAZADO");
            default -> detalle.setEstadoValidacion("EN_PROCESO");
        }
    } 
}
