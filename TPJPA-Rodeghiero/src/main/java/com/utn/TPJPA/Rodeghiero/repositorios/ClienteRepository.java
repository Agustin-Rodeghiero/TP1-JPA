package com.utn.TPJPA.Rodeghiero.repositorios;

import ch.qos.logback.core.net.server.Client;
import com.utn.TPJPA.Rodeghiero.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
