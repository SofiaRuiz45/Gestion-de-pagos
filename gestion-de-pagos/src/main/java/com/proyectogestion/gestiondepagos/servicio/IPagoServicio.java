package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.Pago;

import java.util.List;

public interface IPagoServicio {

    public List<Pago> verHistorial();

    public Pago realizarPago(Pago pago);
}
