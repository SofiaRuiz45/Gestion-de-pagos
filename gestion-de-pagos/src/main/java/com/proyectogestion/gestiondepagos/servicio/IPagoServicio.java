package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.Pago;

import java.util.List;

public interface IPagoServicio {

    public List<Pago> verPagosRealizados();
    //llamar a recibo -- crear

    public Pago realizarPago(Pago pago);

    public Pago buscarPago(Integer id_pago);

}
