package com.example.tvp_appserver.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name =  "detalle_compras")
public class DetalleCompraEntity {
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     private String codigoPaquete;
     private String nombreDestino;
     private Double precio;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private CompraEntity compra;

    
     public Long getId() {
         return id;
     }
     public void setId(Long id) {
         this.id = id;
     }
     public String getCodigoPaquete() {
         return codigoPaquete;
     }
     public void setCodigoPaquete(String codigoPaquete) {
         this.codigoPaquete = codigoPaquete;
     }
     public String getNombreDestino() {
         return nombreDestino;
     }
     public void setNombreDestino(String nombreDestino) {
         this.nombreDestino = nombreDestino;
     }
     public Double getPrecio() {
         return precio;
     }
     public void setPrecio(Double precio) {
         this.precio = precio;
     }

     
}
