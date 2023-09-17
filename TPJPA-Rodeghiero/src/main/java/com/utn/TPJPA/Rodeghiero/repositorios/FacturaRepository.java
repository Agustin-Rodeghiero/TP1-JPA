package com.utn.TPJPA.Rodeghiero.repositorios;

import com.utn.TPJPA.Rodeghiero.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
