package com.utn.TPJPA.Rodeghiero.repositorios;

import com.utn.TPJPA.Rodeghiero.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
