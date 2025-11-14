package com.example.tvp_appserver.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name =  "compras")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CompraEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    private LocalDateTime fechaCompra;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(nullable = false)
    private String correoCliente;

    @Column(nullable = false)
    private String nombreCliente;

    private Double total;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<CompraItemsEntity> items;
    
    
}
