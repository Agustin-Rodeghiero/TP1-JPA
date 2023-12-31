package com.utn.TPJPA.Rodeghiero.entidades;

import com.utn.TPJPA.Rodeghiero.enums.FormaDePago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Factura extends BaseEntidad {

    private int numero;
    private Date fecha;
    private double dto;
    private int total;
    private FormaDePago formaDePago;

}
