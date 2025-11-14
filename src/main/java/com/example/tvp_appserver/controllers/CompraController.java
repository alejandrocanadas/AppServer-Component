package com.example.tvp_appserver.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.tvp_appserver.services.CompraService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.tvp_appserver.DTO.CrearCompraRequest;
import com.example.tvp_appserver.model.CompraEntity;



@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @PostMapping("/crear")
    public ResponseEntity<CompraEntity> crearCompra(@RequestBody CrearCompraRequest request) {
        CompraEntity compra = compraService.crearCompra(request);
        return ResponseEntity.ok(compra);
    }


}