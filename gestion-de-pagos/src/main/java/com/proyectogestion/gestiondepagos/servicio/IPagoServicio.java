package com.proyectogestion.gestiondepagos.servicio;
import com.proyectogestion.gestiondepagos.modelo.Pago;

import java.util.List;

public interface IPagoServicio {

    public List<Pago> verPagosRealizados();

    public Pago realizarPago(Pago pago);

    public Pago buscarPagoPorId(Integer id_pago);

    public List<Pago>buscarPagosPorCliente(String nombreCliente);

    public List<Pago>buscarPagoPorEntidad(String nombreEntidad);

    public List<Pago>buscarPagosPorEstado(String estadoPago);

    public  long contarPagosPorEstado(String estadoPago);

    public List<Pago> obtenerUltimosPagos(Integer cantidad);
}
