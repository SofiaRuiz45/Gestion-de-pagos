package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.modelo.Entidad;
import com.proyectogestion.gestiondepagos.modelo.Pago;

import java.util.List;

public interface IPagoServicio {

    public List<Pago> verPagosRealizados();

    public Pago realizarPago(Pago pago);

    public Pago buscarPagoPorId(Integer id_pago);

    public List<Pago>buscarPagosPorCliente(Cliente cliente);

    public List<Pago>buscarPagoPorEntidad(Entidad entidad);
}
