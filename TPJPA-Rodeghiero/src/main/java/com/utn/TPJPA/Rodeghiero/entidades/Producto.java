package com.utn.TPJPA.Rodeghiero.entidades;

import com.utn.TPJPA.Rodeghiero.enums.TipoProducto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Producto extends BaseEntidad {

    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;
    private TipoProducto tipoProducto;
}
