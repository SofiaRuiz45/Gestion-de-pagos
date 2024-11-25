package com.proyectogestion.gestiondepagos.repositorio;

import com.proyectogestion.gestiondepagos.modelo.Factura;
import com.proyectogestion.gestiondepagos.modelo.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PagoRepositorio extends JpaRepository<Pago, Integer> {
    //busqueda por numero de pago
    Pago findByNumeroPago(Integer numeroPago);
    //se busca un pago realizado a una entidad y un pago realizado por un cliente
    Pago findByFactura(Factura factura);
    @Query("SELECT p FROM Pago p WHERE p.factura.cliente.nombreCliente = :nombreCliente")
    List<Pago>findByNombreCliente(@Param("nombreCliente") String nombreCliente);

    //se busca por nombre de la entidad pagada
    @Query("SELECT p FROM Pago p WHERE p.factura.entidad.nombreEntidad = :nombreEntidad")
    List<Pago>findByNombreEntidad(@Param("nombreEntidad") String nombreEntidad);

    List<Pago> findByEstadoPago(String estadoPago);

    Long countByEstadoPago(String estadoPago);
    @Query("SELECT p FROM Pago p ORDER BY p.fecha_pago DESC")
    Page <Pago> findLastPagos(Pageable pageable);
    
}
