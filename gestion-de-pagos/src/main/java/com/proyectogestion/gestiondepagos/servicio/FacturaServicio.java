package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.modelo.Entidad;
import com.proyectogestion.gestiondepagos.modelo.Factura;
import com.proyectogestion.gestiondepagos.modelo.FacturaDTO;
import com.proyectogestion.gestiondepagos.repositorio.ClienteRepositorio;
import com.proyectogestion.gestiondepagos.repositorio.EntidadRepositorio;
import com.proyectogestion.gestiondepagos.repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service

public class FacturaServicio  implements IFacturaServicio {
    @Autowired
    private FacturaRepositorio facturaRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private EntidadRepositorio entidadRepositorio;

    @Override
    public Factura registrarFactura(Factura factura) {
        // Validar si ya existe una factura con el mismo número
        Factura facturaExistente = facturaRepositorio.findByNumeroFactura(factura.getNumeroFactura());
        if (facturaExistente != null) {
            throw new IllegalArgumentException("Ya existe una factura con el n°: " + factura.getNumeroFactura());
        }

        // Validar cliente
        if (factura.getCliente() != null && factura.getCliente().getId_cliente() != null) {
            Cliente cliente = clienteRepositorio.findById(factura.getCliente().getId_cliente())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            factura.setCliente(cliente);
        }

        // Validar entidad
        if (factura.getEntidad() != null && factura.getEntidad().getId_entidad() != null) {
            Entidad entidad = entidadRepositorio.findById(factura.getEntidad().getId_entidad())
                    .orElseThrow(() -> new RuntimeException("Entidad no encontrada"));
            factura.setEntidad(entidad);
        }

        // Guardar la factura
        return facturaRepositorio.save(factura);
    }

    //registrar factura con nombres
    @Override
    public Factura registrarFacturaMet(FacturaDTO facturaDTO){
        // Validar cliente
        Cliente cliente = clienteRepositorio.findByNombreCliente(facturaDTO.getNombreCliente());

        // Validar entidad
        Entidad entidad = entidadRepositorio.findByNombreEntidad(facturaDTO.getNombreEntidad());

        // Crear objeto Factura
        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setEntidad(entidad);
        factura.setMonto_factura(facturaDTO.getMonto_factura());
        factura.setNumeroFactura(Integer.parseInt(facturaDTO.getNumeroFactura()));
        factura.setFecha_factura(facturaDTO.getFecha_factura());

        // Guardar factura
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

    //busqueda por nombre de cliente en la factura
    @Override
    public List<Factura> buscarPagosPorCliente(String nombreCliente) {
        //pagos realizados por un cliente especifico, se debe de recibir un nombre
        return facturaRepositorio.findByNombreCliente(nombreCliente) ;
    }

}
