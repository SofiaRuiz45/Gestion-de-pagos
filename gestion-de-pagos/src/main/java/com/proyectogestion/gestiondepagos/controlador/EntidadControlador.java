package com.proyectogestion.gestiondepagos.controlador;

import com.proyectogestion.gestiondepagos.modelo.Entidad;
import com.proyectogestion.gestiondepagos.servicio.EntidadServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("gestion-de-pagos")
/*se va a recibir peticiones del puerto 3000*/
@CrossOrigin(value= "http://localhost:3000")
public class EntidadControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(EntidadControlador.class);
    @Autowired
    private EntidadServicio entidadServicio;

    @GetMapping("/entidad")
    public List<Entidad> obtenerEntidades(){
        var entidades = entidadServicio.listarEntidades();
        //
        entidades.forEach((entidad -> logger.info(entidad.toString())));
        return entidades;
    }
    @PostMapping("/entidad")
    public Entidad agregarEntidad(@RequestBody Entidad entidad) {
        logger.info("Entidad a agregar: " + entidad);
        return entidadServicio.registrarEntidad(entidad);
    }
    @GetMapping("/entidad/{id}")
    public ResponseEntity<Entidad> obtenerEnditadPorId(@PathVariable Integer id){
        Entidad entidad = entidadServicio.buscarEntidadPorId(id);
        return null;
        //if(entidad == null)
    }
}