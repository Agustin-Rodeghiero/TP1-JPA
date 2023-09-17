package com.utn.TPJPA.Rodeghiero.repositorios;

import com.utn.TPJPA.Rodeghiero.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {
}
