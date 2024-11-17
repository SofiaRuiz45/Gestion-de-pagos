package com.proyectogestion.gestiondepagos.repositorio;

import com.proyectogestion.gestiondepagos.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    Cliente findByNombreCliente(String nombreCliente);
    @Query("SELECT c FROM Cliente c WHERE c.cuitCliente = :cuitCliente")
    Cliente findByCuitCliente(@Param("cuitCliente")Long cuitCliente);
}
