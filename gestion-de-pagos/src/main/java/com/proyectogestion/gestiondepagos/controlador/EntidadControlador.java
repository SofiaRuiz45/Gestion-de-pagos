package com.proyectogestion.gestiondepagos.controlador;

import com.proyectogestion.gestiondepagos.modelo.Entidad;
import com.proyectogestion.gestiondepagos.servicio.EntidadServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gestion-de-pagos")
@CrossOrigin(value= "http://localhost:3000")
public class EntidadControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(EntidadControlador.class);
    @Autowired
    private EntidadServicio entidadServicio;

    @GetMapping("/entidad")
    public List<Entidad> obtenerEntidades(){
        var entidades = entidadServicio.listarEntidades();
        entidades.forEach((entidad -> logger.info(entidad.toString())));
        return entidades;
    }
}