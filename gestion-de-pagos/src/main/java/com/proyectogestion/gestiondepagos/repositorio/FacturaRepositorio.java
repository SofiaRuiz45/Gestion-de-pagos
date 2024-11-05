package com.proyectogestion.gestiondepagos.repositorio;

import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.modelo.Entidad;
import com.proyectogestion.gestiondepagos.modelo.Factura;
import com.proyectogestion.gestiondepagos.modelo.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
    //busqueda por numero de factura
    Factura findByNumeroFactura(Integer numeroFactura);

    //muestra todas las facturas de un cliente
    List<Factura> findByCliente(Cliente cliente_fac);

    //muestra las facturas de una entidad especifica
    List<Factura> findByEntidad(Entidad entidad_fac);

    @Query("SELECT f FROM Factura f WHERE f.cliente.nombreCliente = :nombreCliente")
    List<Factura> findByNombreCliente(@Param("nombreCliente") String nombreCliente);

}
