package com.example.tvp_appserver.model;

public class DetalleCompraDTO {

    private String idPaquete;
    private String destino;
    private Double valor;
    private String estadoValidacion; // APROBADO / RECHAZADO / EN_PROCESO

    public DetalleCompraDTO() {}

    public DetalleCompraDTO(String idPaquete, String destino, Double valor, String estadoValidacion) {
        this.idPaquete = idPaquete;
        this.destino = destino;
        this.valor = valor;
        this.estadoValidacion = estadoValidacion;
    }

    // Getters y setters
    public String getIdPaquete() {
        return idPaquete;
    }
    public void setIdPaquete(String idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getEstadoValidacion() {
        return estadoValidacion;
    }
    public void setEstadoValidacion(String estadoValidacion) {
        this.estadoValidacion = estadoValidacion;
    }
}
