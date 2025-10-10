package com.example.tvp_appserver.model;

import java.util.List;

import lombok.Data;

@Data
public class CompraRequestDTO {
    private String id_compra;
    private String id_paquete;
    private String id_usuario;
    private String estado_compra; 

    public String getId_compra() {
        return id_compra;
    }

    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }
    
    public String getId_paquete() {
        return id_paquete;
    }
    
    public void setId_paquete(String id_paquete) {
        this.id_paquete = id_paquete;
    }
    
    public String getId_usuario() {
        return id_usuario;
    }
    
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}
