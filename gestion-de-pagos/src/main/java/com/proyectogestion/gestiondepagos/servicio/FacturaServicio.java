package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.modelo.Entidad;
import com.proyectogestion.gestiondepagos.modelo.Factura;
import com.proyectogestion.gestiondepagos.repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FacturaServicio  implements IFacturaServicio {
    @Autowired
    private FacturaRepositorio facturaRepositorio;

    @Override

    public Factura registrarFactura(Factura factura) {
        //se va a realizar una validación en caso de que exista otra factura con el mismo numeroFactura
        Factura facturaExistente= facturaRepositorio.findByNumeroFactura(factura.getNumeroFactura());
        if (facturaExistente != null){
            throw new IllegalArgumentException("Ya existe una factura con el n°: " + factura.getNumeroFactura());
        }
        return facturaRepositorio.save(factura);
    }

    @Override
    public Factura buscarFacturaPorID(Integer id_factura) {
        Factura factura = facturaRepositorio.findById(id_factura).orElse(null);
        return factura;
    }

    @Override
    public List<Factura> listarFacturas() {
        return facturaRepositorio.findAll();
    }
    //busqueda por numero de factura
    @Override
    public Factura buscarFacturaPorNum(Integer numeroFactura) {
        return facturaRepositorio.findByNumeroFactura(numeroFactura);
    }
    @Override
    public List<Factura> buscarFacturasPorCliente(Cliente cliente) {
        return facturaRepositorio.findByCliente(cliente);

    }
//busqueda de las facturas de una entidad
    @Override
    public List<Factura> buscarFacturasPorEntidad(Entidad entidad) {
        return facturaRepositorio.findByEntidad(entidad);
    }


}
