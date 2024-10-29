package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.*;
import com.proyectogestion.gestiondepagos.repositorio.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PagoServicio implements  IPagoServicio{
        @Autowired
        private PagoRepositorio pagoRepositorio;
        @Autowired
        private FacturaRepositorio facturaRepositorio;

        //esto simplemente lo lista, ver si es util o no
        @Override
        public List<Pago> verPagosRealizados() {
                return pagoRepositorio.findAll();
        }

        @Override
        @Transactional
        public Pago realizarPago(Pago pago) {
                Pago pagoExistente = pagoRepositorio.findByNumeroPago(pago.getNumeroPago());
                if(pagoExistente != null){
                        throw new IllegalArgumentException("Actualmente existe un pago con el n°: "+ pago.getNumeroPago());
                }
                // Verifica si la factura existe
                if (pago.getFactura() == null || pago.getFactura().getId_factura() == null) {
                        throw new IllegalArgumentException("La factura asociada no existe o no se ha proporcionado."+ pago.getFactura().getId_factura());
                }
//busqueda por id
                Factura facturaExistente = facturaRepositorio.findById(pago.getFactura().getId_factura()).orElse(null);
                if (facturaExistente == null) {
                        throw new IllegalArgumentException("La factura asociada no existe."+ pago.getFactura().getNumeroFactura());
                }
                if (pago.getFormas_de_pago() != null) {
                        for (FormaPago formaPago : pago.getFormas_de_pago()) {
                                formaPago.setPago(pago); // Asocia cada forma de pago al pago
                        }
                }
                return pagoRepositorio.save(pago);
        }
        @Override
        public Pago buscarPagoPorId(Integer id_pago) {
                Pago pago = pagoRepositorio.findById(id_pago).orElse(null);
                return pago;
        }


        @Override
        public List<Pago> buscarPagosPorCliente(String nombreCliente) {
                //pagos realizados por un cliente especifico, se debe de recibir un nombre
                return pagoRepositorio.findByNombreCliente(nombreCliente) ;
        }


        @Override
        public List<Pago> buscarPagoPorEntidad(Entidad entidad) {
                return List.of();
        }
}
