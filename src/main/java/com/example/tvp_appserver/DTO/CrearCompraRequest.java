package com.example.tvp_appserver.DTO;

import java.util.List;

import lombok.Data;

@Data
public class CrearCompraRequest {
    private Long clienteId;
    private String correoCliente;
    private String nombreCliente;
    private String numeroTarjeta;
    private List<CompraItemsRequest> items;
}
