package com.utn.TPJPA.Rodeghiero.repositorios;

import com.utn.TPJPA.Rodeghiero.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
