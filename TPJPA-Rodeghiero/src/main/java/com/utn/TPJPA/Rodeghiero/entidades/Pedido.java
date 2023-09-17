package com.utn.TPJPA.Rodeghiero.entidades;

import com.utn.TPJPA.Rodeghiero.enums.Estado;
import com.utn.TPJPA.Rodeghiero.enums.TipoDeEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pedido extends BaseEntidad {

    private Date fecha;
    private double total;
    private TipoDeEnvio tipoDeEnvio;
    private Estado estado;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "factura-id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Pedido-id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detallePedidoed){

        detallePedidos.add(detallePedidoed);
    }
}
