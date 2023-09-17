package com.utn.TPJPA.Rodeghiero.repositorios;

import com.utn.TPJPA.Rodeghiero.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
