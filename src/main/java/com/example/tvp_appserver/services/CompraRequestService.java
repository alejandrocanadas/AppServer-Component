package com.example.tvp_appserver.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.tvp_appserver.model.CompraEntity;
import com.example.tvp_appserver.model.CompraRequestDTO;
import com.example.tvp_appserver.model.DetalleCompraDTO;
import com.example.tvp_appserver.model.DetalleCompraEntity;
import com.example.tvp_appserver.repository.CompraRepository;

@Service
public class CompraRequestService {

    private final CompraRepository compraRepository;
    private final OTNService otnService;

    public CompraRequestService(CompraRepository compraRepository, OTNService otnService) {
        this.compraRepository = compraRepository;
        this.otnService = otnService;
    }

    public CompraRequestDTO continuarCompra(CompraRequestDTO compraRequestDTO) {

        List<DetalleCompraDTO> paquetesValidados = compraRequestDTO.getDetalles().stream()
            .peek(otnService::validarPaquete) 
            .toList();

        CompraEntity compra = new CompraEntity();
        compra.setNumeroCompra(compraRequestDTO.getNumeroCompra());
        compra.setCedulaCliente(compraRequestDTO.getCedulaCliente());
        compra.setValorTotal(compraRequestDTO.getValorTotal());
        compra.setEstado(compraRequestDTO.getEstado());
        compra.setFechaCreacion(compraRequestDTO.getFechaCreacion());
        compra.setFechaActualizacion(compraRequestDTO.getFechaActualizacion());

        List<DetalleCompraEntity> detallesEntities = paquetesValidados.stream()
            .map(d -> {
                DetalleCompraEntity detalle = new DetalleCompraEntity();
                detalle.setIdPaquete(d.getIdPaquete());
                detalle.setDestino(d.getDestino());
                detalle.setValor(d.getValor());
                detalle.setEstadoValidacion(d.getEstadoValidacion());
                detalle.setCompra(compra); // relación bidireccional
                return detalle;
            })
            .toList();

        compra.setDetalles(detallesEntities);

        compraRepository.save(compra);

        return compraRequestDTO;
    }
}