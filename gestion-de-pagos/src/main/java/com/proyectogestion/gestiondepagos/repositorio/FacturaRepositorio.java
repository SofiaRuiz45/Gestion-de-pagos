package com.proyectogestion.gestiondepagos.repositorio;

import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
    //busqueda por numero de factura
    Factura findByNumeroFactura(Integer numeroFactura);

    //es parecida a la de abajo, no lo veo tan necesario
    //Factura findByIdCliente_Id(Cliente idCliente);

    //muestra todas las facturas de un cliente
    List<Factura> findByCliente(Cliente cliente);

}
