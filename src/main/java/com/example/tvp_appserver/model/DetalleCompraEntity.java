package com.example.tvp_appserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_compras")
public class DetalleCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idPaquete;        
    private String destino;          
    private Double valor;            
    private String estadoValidacion; 

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private CompraEntity compra;

    public DetalleCompraEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIdPaquete() { return idPaquete; }
    public void setIdPaquete(String idPaquete) { this.idPaquete = idPaquete; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public String getEstadoValidacion() { return estadoValidacion; }
    public void setEstadoValidacion(String estadoValidacion) { this.estadoValidacion = estadoValidacion; }

    public CompraEntity getCompra() { return compra; }
    public void setCompra(CompraEntity compra) { this.compra = compra; }
}

