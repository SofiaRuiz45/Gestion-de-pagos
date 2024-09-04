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
        public List<Pago> verHistorial() {
            return pagoRepositorio.findAll();
        }

        @Override
        public Pago realizarPago(Pago pago) {
            return pagoRepositorio.save(pago);
        }
}
