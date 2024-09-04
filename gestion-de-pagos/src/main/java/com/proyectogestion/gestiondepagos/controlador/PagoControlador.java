package com.proyectogestion.gestiondepagos.controlador;


import com.proyectogestion.gestiondepagos.servicio.PagoServicio;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping
@CrossOrigin(value = "http://localhost:3000")
public class PagoControlador{
    private static final Logger logger =
            LoggerFactory.getLogger(PagoControlador.class);
    @Autowired
    private PagoServicio pagoServicio;

    @GetMapping("/Pago")
}
