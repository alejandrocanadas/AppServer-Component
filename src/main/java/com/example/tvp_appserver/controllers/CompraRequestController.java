package com.example.tvp_appserver.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.tvp_appserver.services.CompraRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.tvp_appserver.model.CompraRequestDTO;

@RestController
public class CompraRequestController {
    private final CompraRequestService compraRequestService;

    public CompraRequestController(CompraRequestService compraRequestService){
        this.compraRequestService = compraRequestService;
    }

    @PostMapping("/tvp/compra")
    public ResponseEntity<CompraRequestDTO> continuarCompra(@RequestBody CompraRequestDTO compraRequestDTO){
        CompraRequestDTO resultado = compraRequestService.continuarCompra(compraRequestDTO);
        return ResponseEntity.ok(resultado);
    }
}
