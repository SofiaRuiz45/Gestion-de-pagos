package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.modelo.Factura;

import java.util.List;

public interface IFacturaServicio {

    public Factura registrarFactura(Factura factura);

    public Factura buscarFacturaPorID(Integer id_factura);

    public List<Factura> listarFacturas();

    public Factura buscarFacturaPorNum(Integer numero_factura);

    public List<Factura> buscarFacturasPorCliente(Cliente cliente);
}
