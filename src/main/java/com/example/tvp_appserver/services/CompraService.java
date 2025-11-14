package com.example.tvp_appserver.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.tvp_appserver.DTO.CrearCompraRequest;
import com.example.tvp_appserver.model.CompraEntity;
import com.example.tvp_appserver.model.CompraItemsEntity;
import com.example.tvp_appserver.model.Estado;
import com.example.tvp_appserver.repository.CompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final CompraProducerService compraProducer;  

    public CompraEntity crearCompra(CrearCompraRequest request) {

        double total = request.getItems().stream()
                .mapToDouble(i -> i.getCantidad() * i.getPrecioUnitario())
                .sum();

        CompraEntity compra = CompraEntity.builder()
                .clienteId(request.getClienteId())
                .correoCliente(request.getCorreoCliente())
                .nombreCliente(request.getNombreCliente())
                .fechaCompra(LocalDateTime.now())
                .estado(Estado.PENDIENTE)
                .total(total)
                .build();

        List<CompraItemsEntity> items = request.getItems().stream()
                .map(i -> CompraItemsEntity.builder()
                        .paqueteId(i.getPaqueteId())
                        .cantidad(i.getCantidad())
                        .precioUnitario(i.getPrecioUnitario())
                        .compra(compra)
                        .build())
                .toList();

        compra.setItems(items);

        CompraEntity savedCompra = compraRepository.save(compra);

        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("compraId", savedCompra.getId());
        mensaje.put("clienteId", request.getClienteId());
        mensaje.put("numeroTarjeta", request.getNumeroTarjeta());
        mensaje.put("total", total);

        List<Map<String, Object>> itemsJson = request.getItems().stream()
                .map(i -> {
                    Map<String, Object> item = new HashMap<>();
                    item.put("paqueteId", i.getPaqueteId());
                    item.put("cantidad", i.getCantidad());
                    item.put("precioUnitario", i.getPrecioUnitario());
                    return item;
                }).toList();

        mensaje.put("items", itemsJson);

        compraProducer.enviarMensajeAProcesar(mensaje);

        return savedCompra;
    }
}

