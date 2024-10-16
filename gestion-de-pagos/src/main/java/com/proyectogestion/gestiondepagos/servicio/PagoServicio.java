package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.Pago;
import com.proyectogestion.gestiondepagos.repositorio.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PagoServicio implements  IPagoServicio{
        @Autowired
        private PagoRepositorio pagoRepositorio;

        //esto simplemente lo lista, ver si es util o no
        @Override
        public List<Pago> verPagosRealizados() {
                return List.of();
        }

        @Override
        public Pago realizarPago(Pago pago) {
            return pagoRepositorio.save(pago);
        }

        @Override
        public Pago buscarPago(Integer id_pago){
                Pago pago = pagoRepositorio.findById(id_pago).orElse(null);
                return pago;
        }
}
