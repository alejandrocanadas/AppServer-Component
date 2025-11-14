package com.example.tvp_appserver.DTO;

public class CompraItemsRequest {
    private Long paqueteId;
    private Integer cantidad;
    private Double precioUnitario;
    
    public Long getPaqueteId() {
        return paqueteId;
    }
    public void setPaqueteId(Long paqueteId) {
        this.paqueteId = paqueteId;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
}
