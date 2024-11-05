package com.proyectogestion.gestiondepagos.repositorio;

import com.proyectogestion.gestiondepagos.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    Cliente findByNombreCliente(String nombreCliente);
}
